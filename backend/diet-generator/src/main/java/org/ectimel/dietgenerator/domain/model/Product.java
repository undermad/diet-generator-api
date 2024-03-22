package org.ectimel.dietgenerator.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private String name;
    private ProductType productType;
    private Nutrients nutrients;
    private Filler filler;


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

    public BigDecimal calculateProductGrams(Filler filler, BigDecimal grams) {
        if (filler.equals(Filler.PROTEIN)) {
            return calculateProductGramsForRequiredProteins(grams);
        } else if (filler.equals(Filler.CARBOHYDRATE)) {
            return calculateProductGramsForRequiredCarbohydrates(grams);
        } else if (filler.equals(Filler.FAT)) {
            return calculateProductGramsForRequiredFats(grams);
        }
        return BigDecimal.valueOf(0);
    }

    private BigDecimal calculateProductGramsForRequiredCarbohydrates(BigDecimal requiredCarbohydrates) {
        BigDecimal totalCarbohydrates = nutrients.getCarbohydrates().getTotalCarbohydrates();
        return requiredCarbohydrates.divide(totalCarbohydrates, 2, RoundingMode.HALF_DOWN)
                .multiply(BigDecimal.valueOf(100));
    }

    private BigDecimal calculateProductGramsForRequiredProteins(BigDecimal requiredProteins) {
        BigDecimal totalProteins = nutrients.getProteins().getTotalProteins();
        return requiredProteins.divide(totalProteins, 2, RoundingMode.HALF_DOWN)
                .multiply(BigDecimal.valueOf(100));
    }

    private BigDecimal calculateProductGramsForRequiredFats(BigDecimal requiredFats) {
        BigDecimal totalFats = nutrients.getFats().getTotalFats();
        return requiredFats.divide(totalFats, 2, RoundingMode.HALF_DOWN)
                .multiply(BigDecimal.valueOf(100));
    }

    public boolean isFiller() {
        return !this.getFiller().equals(Filler.NONE);
    }


}
