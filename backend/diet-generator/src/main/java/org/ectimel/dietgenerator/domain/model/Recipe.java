package org.ectimel.dietgenerator.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@ToString
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Recipe {

    private final Map<Product, BigDecimal> ingredientsProportion;
    private final Nutrients nutrients;
    private final BigDecimal basePortion;
    private boolean isScalable;
    private String name;


    public Recipe(Map<Product, BigDecimal> ingredientsProportion, BigDecimal basePortion, boolean isScalable, String name) {
        validateProducts(ingredientsProportion, isScalable);
        this.name = name;
        this.basePortion = basePortion;
        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients();
        this.isScalable = isScalable;
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

    private void validateProducts(Map<Product, BigDecimal> ingredientsProportion, boolean isScalable) {
        try {
            AtomicReference<Double> total = new AtomicReference<>(0D);
            AtomicReference<Boolean> canScale = new AtomicReference<>(false);
            ingredientsProportion.forEach((product, bigDecimal) -> {
                if(product.isFiller()) canScale.set(true);
                total.updateAndGet(v -> (v + bigDecimal.doubleValue()));
            });
            if (total.get() != 100) {
                throw new Exception("Proportion percentage must equal 100.");
            } else if (isScalable && !canScale.get()) {
                throw new Exception("Scalable recipe must have at least one filler");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
