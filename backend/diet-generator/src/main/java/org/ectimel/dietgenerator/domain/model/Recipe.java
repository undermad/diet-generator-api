package org.ectimel.dietgenerator.domain.model;

import lombok.*;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class Recipe {

    private UUID id;
    private String name;
    private Map<Product, BigDecimal> ingredientsProportion;
    private Nutrients nutrients;
    private BigDecimal basePortionInGrams;
    private boolean isScalable;
    private String howToPrepare;
    private List<DietType> dietTypes;
    private List<MealType> mealTypes;


    private Recipe(Map<Product, BigDecimal> ingredientsProportion, BigDecimal basePortionInGrams, boolean isScalable, String name, String howToPrepare, List<DietType> dietTypes, List<MealType> mealTypes) {
        validateProducts(ingredientsProportion, isScalable);
        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients();
        this.name = name;
        this.basePortionInGrams = basePortionInGrams;
        this.isScalable = isScalable;
        this.howToPrepare = howToPrepare;
        this.dietTypes = dietTypes;
    }

    @Builder
    public static Recipe createRecipe(Map<Product, BigDecimal> ingredientsProportion, BigDecimal basePortionInGrams, boolean isScalable, String name, String howToPrepare, List<DietType> dietType, List<MealType> mealTypes){
        return new Recipe(ingredientsProportion, basePortionInGrams, isScalable, name, howToPrepare, dietType, mealTypes);
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

    private static void validateProducts(Map<Product, BigDecimal> ingredientsProportion, boolean isScalable) {
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
