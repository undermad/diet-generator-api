package org.ectimel.dietgenerator.domain.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@ToString
@Getter
public class Recipe {

    private final Map<Product, BigDecimal> ingredientsProportion;
    private final Nutrients nutrients;

    public Recipe(Map<Product, BigDecimal> ingredientsProportion) {
        validateProportion(ingredientsProportion);

        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients();
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
