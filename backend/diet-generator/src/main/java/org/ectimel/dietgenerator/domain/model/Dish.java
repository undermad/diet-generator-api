package org.ectimel.dietgenerator.domain.model;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Getter
public class Dish {

    private Map<Product, BigDecimal> productToGrams;
    private Nutrients nutrients;
    private Recipe recipe;
    private Map<Filler, Integer> numberOfFillers;

    private Dish(Map<Product, BigDecimal> productToGrams, Recipe recipe) {
        this.productToGrams = productToGrams;
        this.nutrients = calculateNutrients();
        this.recipe = recipe;
        this.numberOfFillers = populateFillers();
    }

    private Map<Filler, Integer> populateFillers() {
        Map<Filler, Integer> fillers = new HashMap<>();
        Arrays.stream(Filler.values()).forEach(filler -> {
            if (!filler.equals(Filler.NONE)) {
                fillers.put(filler, countFillers(filler));
            }
        });
        return fillers;
    }

    public static Dish createDish(Recipe recipe) {
        Map<Product, BigDecimal> calculatedRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            calculatedRecipeToGram.put(product, recipe.getBasePortionInGrams()
                    .multiply(proportion.divide(BigDecimal.valueOf(100), 2, RoundingMode.FLOOR)));
        }));
        return new Dish(calculatedRecipeToGram, recipe);
    }

    public static Dish createDish(Recipe recipe, BigDecimal requiredCalories) {
        BigDecimal recipeTotalCalories = recipe.getNutrients().getCalories().getTotalCalories();
        BigDecimal factor = requiredCalories.divide(recipeTotalCalories, 3, RoundingMode.HALF_UP);
        Map<Product, BigDecimal> emptyRecipeToGram = new HashMap<>();
        recipe.getIngredientsProportion().forEach(((product, proportion) -> {
            emptyRecipeToGram.put(product, proportion.multiply(factor));
        }));
        return new Dish(emptyRecipeToGram, recipe);
    }

    private Nutrients calculateNutrients() {
        Nutrients mealNutrients = Nutrients.createEmptyNutrients();
        productToGrams.forEach(((product, bigDecimal) -> {
            mealNutrients.addNutrients(product.calculateNutrients(bigDecimal));
        }));
        return mealNutrients;
    }

    public Nutrients increaseFiller(Filler filler, BigDecimal grams) {
        Nutrients totalAddedNutrients = Nutrients.createEmptyNutrients();
        Integer fillerPopulation = numberOfFillers.get(filler);
        if (fillerPopulation == null) return totalAddedNutrients;

        BigDecimal numberOfProductFillers = BigDecimal.valueOf(fillerPopulation);
        if (recipe.isScalable() && numberOfProductFillers.doubleValue() > 0) {
            BigDecimal gramsFraction = grams.divide(numberOfProductFillers, 2, RoundingMode.HALF_DOWN);
            productToGrams.forEach(((product, bigDecimal) -> {
                if (product.getFiller().equals(filler)) {
                    BigDecimal currentGrams = productToGrams.get(product);
                    BigDecimal productGramsToAdd = product.calculateProductGrams(filler, gramsFraction);
                    productToGrams.put(product, currentGrams.add(productGramsToAdd));
                    Nutrients subtractedNutrients = product.calculateNutrients(productGramsToAdd);
                    nutrients.addNutrients(subtractedNutrients);
                    totalAddedNutrients.addNutrients(subtractedNutrients);
                }
            }));
        }
        return totalAddedNutrients;
    }

    public Nutrients reduceFiller(Filler filler, BigDecimal grams) {
        Nutrients totalReducedNutrients = Nutrients.createEmptyNutrients();
        Integer fillerPopulation = numberOfFillers.get(filler);
        if (fillerPopulation == null) return totalReducedNutrients;

        BigDecimal numberOfProductFillers = BigDecimal.valueOf(fillerPopulation);
        if (recipe.isScalable() && numberOfProductFillers.doubleValue() > 0) {
            BigDecimal gramsFraction = grams.divide(numberOfProductFillers, 2, RoundingMode.HALF_DOWN);

            Map<Product, BigDecimal> fillersToGrams = productToGrams.entrySet().stream()
                    .filter(entry -> entry.getKey().getFiller().equals(filler))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue));

            fillersToGrams.forEach(((product, currentGrams) -> {
                BigDecimal productGramsToRemove = product.calculateProductGrams(filler, gramsFraction);
                if (currentGrams.subtract(productGramsToRemove).doubleValue() > 0) {
                    productToGrams.put(product, currentGrams.subtract(productGramsToRemove));
                    Nutrients subtractedNutrients = product.calculateNutrients(productGramsToRemove);
                    nutrients.subtractNutrients(subtractedNutrients);
                    totalReducedNutrients.addNutrients(subtractedNutrients);
                }
            }));
        }
        return totalReducedNutrients;
    }


    private int countFillers(Filler filler) {
        AtomicReference<Integer> allFillers = new AtomicReference<>(0);
        if (recipe.isScalable()) {
            productToGrams.forEach(((product, currentGrams) -> {
                if (product.getFiller().equals(filler))
                    allFillers.getAndSet(allFillers.get() + 1);
            }));
        }
        return allFillers.get();
    }


}
