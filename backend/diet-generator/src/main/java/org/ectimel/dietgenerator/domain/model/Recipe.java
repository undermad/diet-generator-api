package org.ectimel.dietgenerator.domain.model;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@ToString
public class Recipe {

    private final Map<Product, BigDecimal> ingredientsProportion;
    private final Nutrients nutrients;

    public Recipe(Map<Product, BigDecimal> ingredientsProportion) {
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


}
