package org.ectimel.dietgenerator.domain.model;

import lombok.*;
import org.ectimel.dietgenerator.domain.generator.diet.DietType;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;
import java.util.*;
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
    private Set<Filler> scalableFillers;

    private Recipe(Map<Product, BigDecimal> ingredientsProportion, BigDecimal basePortionInGrams, boolean isScalable, String name, String howToPrepare, List<DietType> dietTypes, List<MealType> mealTypes) {
        validateProducts(ingredientsProportion, isScalable);
        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients(ingredientsProportion);
        this.name = name;
        this.basePortionInGrams = basePortionInGrams;
        this.isScalable = isScalable;
        this.howToPrepare = howToPrepare;
        this.dietTypes = dietTypes;
        this.mealTypes = mealTypes;
        this.scalableFillers = findScalableFillers(ingredientsProportion);
    }

    @Builder
    @NonNull
    public static Recipe createRecipe( Map<Product, BigDecimal> ingredientsProportion, BigDecimal basePortionInGrams, boolean isScalable, String name, String howToPrepare, List<DietType> dietType, List<MealType> mealTypes){
        return new Recipe(ingredientsProportion, basePortionInGrams, isScalable, name, howToPrepare, dietType, mealTypes);
    }

    private static Set<Filler> findScalableFillers(Map<Product, BigDecimal> products) {
        Set<Filler> fillers = new HashSet<>();
        products.forEach((product, bigDecimal) -> {
            if(product.isFiller() && product.getFiller() != Filler.NONE) {
                fillers.add(product.getFiller());
            }
        });
        return fillers;
    }

    private Nutrients calculateNutrients(Map<Product, BigDecimal> ingredientsProportion) {
        Nutrients calculatedNutrients = Nutrients.createEmptyNutrients();

        ingredientsProportion.forEach((product, percentage) -> {
            Nutrients productNutrients = product.calculateNutrients(percentage);
            calculatedNutrients.addNutrients(productNutrients);
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
