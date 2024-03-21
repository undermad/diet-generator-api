package org.ectimel.dietgenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
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

    public void addNutrients(Nutrients nutrientsToAdd) {
        addCalories(nutrientsToAdd.getCalories());
        addCarbohydrates(nutrientsToAdd.getCarbohydrates());
        addFats(nutrientsToAdd.getFats());
        addProteins(nutrientsToAdd.getProteins());
    }


    public void addCalories(Calories calories) {
        this.calories.setTotalCalories(this.calories.getTotalCalories().add(calories.getTotalCalories()));
    }

    public void addCarbohydrates(Carbohydrates carbohydrates) {
        this.carbohydrates.setTotalCarbohydrates(this.carbohydrates.getTotalCarbohydrates().add(carbohydrates.getTotalCarbohydrates()));
        this.carbohydrates.setFiber(this.carbohydrates.getFiber().add(carbohydrates.getFiber()));
        this.carbohydrates.setSugar(this.carbohydrates.getSugar().add(carbohydrates.getSugar()));
    }

    public void addProteins(Proteins proteins) {
        this.proteins.setTotalProteins(this.proteins.getTotalProteins().add(proteins.getTotalProteins()));
    }

    public void addFats(Fats fats) {
        this.fats.setTotalFats(this.fats.getTotalFats().add(fats.getTotalFats()));
        this.fats.setSaturatedFats(this.fats.getSaturatedFats().add(fats.getSaturatedFats()));
    }


}
