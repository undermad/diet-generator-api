package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Product {

    private String name;
    private ProductType productType;
    private Nutrients nutrients;

    public Calories getCalories() {
        return this.nutrients.getCalories();
    }

    public Nutrients calculateNutrients(Double grams) {
        return new Nutrients(calculateCalories(grams),
                calculateCarbohydrates(grams),
                calculateProteins(grams),
                calculateFats(grams));
    }

    public Calories calculateCalories(Double grams) {
        double totalCaloriesInGram = this.nutrients.getCalories().getCalories() / 100;
        return new Calories(totalCaloriesInGram * grams);
    }

    public Carbohydrates calculateCarbohydrates(Double grams) {
        double totalCarbohydratesInGram = this.nutrients.getCarbohydrates().getTotalCarbohydrates() / 100;
        double fibreInGram = this.nutrients.getCarbohydrates().getFiber() / 100;
        double sugarInGram = this.nutrients.getCarbohydrates().getSugar() / 100;

        return new Carbohydrates(totalCarbohydratesInGram * grams, fibreInGram * grams, sugarInGram * grams);
    }

    public Proteins calculateProteins(Double grams) {
        double totalProteinsInGram = this.nutrients.getProteins().getTotalProteins() / 100;
        return new Proteins(totalProteinsInGram * grams);
    }

    public Fats calculateFats(Double grams) {
        double totalFatsInGram = this.nutrients.getFats().getTotalFats() / 100;
        double saturatedFatInGram = this.nutrients.getFats().getSaturatedFats() / 100;
        return new Fats(totalFatsInGram * grams, saturatedFatInGram * grams);
    }


}
