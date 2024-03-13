package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@ToString
@Builder
@Getter
@Setter
public class Recipe {

    private final Map<Product, BigDecimal> ingredientsProportion;
    private final Nutrients nutrients;

    private Product proteinFiller;
    private Product fatFiller;
    private Product carbohydrateFiller;


    public Recipe(Map<Product, BigDecimal> ingredientsProportion) {
        validateProportion(ingredientsProportion);

        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients();
    }

    public Nutrients calculateNutrients(BigDecimal grams) {
        Nutrients calculatedNutrients = Nutrients.createEmptyNutrients();
        ingredientsProportion.forEach(((product, percentage) -> {
            BigDecimal productInGrams = percentage.multiply(grams.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
            Nutrients productNutrients = product.calculateNutrients(productInGrams);
            calculatedNutrients.addNutrients(productNutrients);
        }));
        return calculatedNutrients;
    }

    private Nutrients calculateNutrients() {
        Nutrients calculatedNutrients = Nutrients.createEmptyNutrients();

        ingredientsProportion.forEach((product, percentage) -> {
            Nutrients productNutrients = product.calculateNutrients(percentage);

            calculatedNutrients.addCalories(productNutrients.getCalories());
            calculatedNutrients.addCarbohydrates(productNutrients.getCarbohydrates());
            calculatedNutrients.addProteins(productNutrients.getProteins());
            calculatedNutrients.addFats(productNutrients.getFats());

        });
        return calculatedNutrients;
    }

    private void validateProportion(Map<Product, BigDecimal> ingredientsProportion) {
        AtomicReference<Double> total = new AtomicReference<>(0D);
        ingredientsProportion.forEach((product, bigDecimal) -> {
            total.updateAndGet(v -> (v + bigDecimal.doubleValue()));
        });
        try {
            if (total.get() != 100) {
                throw new Exception("Proportion percentage must equal 100.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
