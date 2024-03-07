package org.ectimel.dietgenerator.domain.model;

import lombok.ToString;

import java.util.Map;

@ToString
public class Recipe {

    private Map<Product, Integer> ingredientsProportion;
    private Nutrients nutrients;

    public Recipe(Map<Product, Integer> ingredientsProportion) {
        this.ingredientsProportion = ingredientsProportion;
        this.nutrients = calculateNutrients();
    }

    private Nutrients calculateNutrients() {
        Nutrients nutrients = new Nutrients(new Calories(0D), new Carbohydrates(0D, 0D, 0D), new Proteins(0D), new Fats(0D, 0D));

        ingredientsProportion.forEach((product, percentage) -> {
            Nutrients productNutrients = product.calculateNutrients(percentage.doubleValue());

            nutrients.addCalories(productNutrients.getCalories());
            nutrients.addCarbohydrates(productNutrients.getCarbohydrates());
            nutrients.addProteins(productNutrients.getProteins());
            nutrients.addFats(productNutrients.getFats());

        });
        return nutrients;
    }


}
