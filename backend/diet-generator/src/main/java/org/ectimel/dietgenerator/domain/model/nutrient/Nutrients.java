package org.ectimel.dietgenerator.domain.model.nutrient;

import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrients {

    private Calories calories;
    private Carbohydrates carbohydrates;
    private Proteins proteins;
    private Fats fats;

    public static Nutrients createEmptyNutrients() {
        return new Nutrients(
                new Calories(new BigDecimal("0")),
                new Carbohydrates(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
                new Proteins(new BigDecimal("0")),
                new Fats(new BigDecimal("0"), new BigDecimal("0")));
    }

    public void addNutrients(Nutrients nutrients) {
        if(nutrients == null) return;
        addCalories(nutrients.getCalories());
        addCarbohydrates(nutrients.getCarbohydrates());
        addFats(nutrients.getFats());
        addProteins(nutrients.getProteins());
    }

    public void subtractNutrients(Nutrients nutrients) {
        if(nutrients == null) return;
        subtractCalories(nutrients.getCalories());
        subtractCarbohydrates(nutrients.getCarbohydrates());
        subtractFats(nutrients.getFats());
        subtractProteins(nutrients.getProteins());
    }


    private void addCalories(Calories calories) {
        this.calories.setTotalCalories(this.calories.getTotalCalories().add(calories.getTotalCalories()));
    }

    private void addCarbohydrates(Carbohydrates carbohydrates) {
        this.carbohydrates.setTotalCarbohydrates(this.carbohydrates.getTotalCarbohydrates().add(carbohydrates.getTotalCarbohydrates()));
        this.carbohydrates.setFiber(this.carbohydrates.getFiber().add(carbohydrates.getFiber()));
        this.carbohydrates.setSugar(this.carbohydrates.getSugar().add(carbohydrates.getSugar()));
    }

    private void addProteins(Proteins proteins) {
        this.proteins.setTotalProteins(this.proteins.getTotalProteins().add(proteins.getTotalProteins()));
    }

    private void addFats(Fats fats) {
        this.fats.setTotalFats(this.fats.getTotalFats().add(fats.getTotalFats()));
        this.fats.setSaturatedFats(this.fats.getSaturatedFats().add(fats.getSaturatedFats()));
    }

    private void subtractCalories(Calories calories) {
        this.calories.setTotalCalories(this.calories.getTotalCalories().subtract(calories.getTotalCalories()));
    }

    private void subtractCarbohydrates(Carbohydrates carbohydrates) {
        this.carbohydrates.setTotalCarbohydrates(this.carbohydrates.getTotalCarbohydrates().subtract(carbohydrates.getTotalCarbohydrates()));
        this.carbohydrates.setFiber(this.carbohydrates.getFiber().subtract(carbohydrates.getFiber()));
        this.carbohydrates.setSugar(this.carbohydrates.getSugar().subtract(carbohydrates.getSugar()));
    }

    private void subtractFats(Fats fats) {
        this.fats.setTotalFats(this.fats.getTotalFats().subtract(fats.getTotalFats()));
        this.fats.setSaturatedFats(this.fats.getSaturatedFats().subtract(fats.getSaturatedFats()));
    }

    private void subtractProteins(Proteins proteins) {
        this.proteins.setTotalProteins(this.proteins.getTotalProteins().subtract(proteins.getTotalProteins()));
    }


}
