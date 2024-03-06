package org.ectimel.dietgenerator.domain.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Recipe {

    private Map<Product, Integer> ingredientsProportion;


    public Calories calculateKcal() {
        AtomicReference<Double> totalCaloriesPer100g = new AtomicReference<>((double) 0);
        ingredientsProportion.forEach((product, percentage) -> {
            double caloriesPerGram = product.getCalories() / 100;
            totalCaloriesPer100g.updateAndGet(v -> (v + caloriesPerGram * percentage));
        });
        return new Calories(totalCaloriesPer100g.get());
    }



}
