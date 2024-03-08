package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
@ToString
@Builder
public class Product {

    private String name;
    private ProductType productType;
    private Nutrients nutrients;

    public Nutrients calculateNutrients(BigDecimal grams) {
        return new Nutrients(calculateCalories(grams),
                calculateCarbohydrates(grams),
                calculateProteins(grams),
                calculateFats(grams));
    }

    public Calories calculateCalories(BigDecimal grams) {
        BigDecimal totalCaloriesInGram = this.nutrients.getCalories().getTotalCalories()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Calories(totalCaloriesInGram.multiply((grams)));
    }

    public Carbohydrates calculateCarbohydrates(BigDecimal grams) {

        BigDecimal totalCarbohydratesInGram = this.nutrients.getCarbohydrates().getTotalCarbohydrates()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal fibreInGram = this.nutrients.getCarbohydrates().getFiber()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal sugarInGram = this.nutrients.getCarbohydrates().getSugar()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return new Carbohydrates(totalCarbohydratesInGram.multiply(grams), fibreInGram.multiply(grams), sugarInGram.multiply(grams));
    }

    public Proteins calculateProteins(BigDecimal grams) {
        BigDecimal totalProteinsInGram = this.nutrients.getProteins().getTotalProteins()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Proteins(totalProteinsInGram.multiply(grams));
    }

    public Fats calculateFats(BigDecimal grams) {
        BigDecimal totalFatsInGram = this.nutrients.getFats().getTotalFats()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal saturatedFatInGram = this.nutrients.getFats().getSaturatedFats()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Fats(totalFatsInGram.multiply(grams), saturatedFatInGram.multiply(grams));
    }


}
