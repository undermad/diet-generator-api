package org.ectimel.dietgenerator.domain.model;

import lombok.*;
import org.ectimel.dietgenerator.domain.model.nutrient.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;


@Data
@ToString
@Builder
public class Product {

    private UUID id;
    private String name;
    private Nutrients nutrients;
    private Filler filler;

    public Nutrients calculateNutrients(BigDecimal grams) {
        if (grams == null || grams.doubleValue() <= 0) {
            return Nutrients.createEmptyNutrients();
        }
        return new Nutrients(calculateCalories(grams),
                calculateCarbohydrates(grams),
                calculateProteins(grams),
                calculateFats(grams));
    }

    public BigDecimal calculateProductGramsForRequiredFiller(Filler filler, BigDecimal fillerGrams) {
        if (filler == null || fillerGrams == null || fillerGrams.doubleValue() <= 0) {
            return BigDecimal.valueOf(0);
        }

        if (filler.equals(Filler.PROTEIN)) {
            return calculateProductGramsForRequiredProteins(fillerGrams).setScale(0, RoundingMode.HALF_DOWN);
        } else if (filler.equals(Filler.CARBOHYDRATE)) {
            return calculateProductGramsForRequiredCarbohydrates(fillerGrams).setScale(0, RoundingMode.HALF_DOWN);
        } else if (filler.equals(Filler.FAT)) {
            return calculateProductGramsForRequiredFats(fillerGrams).setScale(0, RoundingMode.HALF_DOWN);
        }
        return BigDecimal.valueOf(0);
    }

    public boolean isFiller() {
        if(filler == null) return false;
        return !this.getFiller().equals(Filler.NONE);
    }

    private Calories calculateCalories(BigDecimal grams) {
        BigDecimal totalCaloriesInGram = this.nutrients.getCalories().getTotalCalories()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Calories(totalCaloriesInGram.multiply((grams)).setScale(0, RoundingMode.HALF_DOWN));
    }

    private Carbohydrates calculateCarbohydrates(BigDecimal grams) {

        BigDecimal totalCarbohydratesInGram = this.nutrients.getCarbohydrates().getTotalCarbohydrates()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal fibreInGram = this.nutrients.getCarbohydrates().getFiber()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal sugarInGram = this.nutrients.getCarbohydrates().getSugar()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return new Carbohydrates(totalCarbohydratesInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN),
                fibreInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN),
                sugarInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN));
    }

    private Proteins calculateProteins(BigDecimal grams) {
        BigDecimal totalProteinsInGram = this.nutrients.getProteins().getTotalProteins()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Proteins(totalProteinsInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN));
    }

    private Fats calculateFats(BigDecimal grams) {
        BigDecimal totalFatsInGram = this.nutrients.getFats().getTotalFats()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal saturatedFatInGram = this.nutrients.getFats().getSaturatedFats()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return new Fats(totalFatsInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN),
                saturatedFatInGram.multiply(grams).setScale(0, RoundingMode.HALF_DOWN));
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

}
