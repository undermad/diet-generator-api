package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Nutrients {

    private Calories calories;
    private Carbohydrates carbohydrates;
    private Proteins proteins;
    private Fats fats;


    public void addCalories(Calories calories) {
        this.calories.setCalories(this.calories.getCalories() + calories.getCalories());
    }

    public void addCarbohydrates(Carbohydrates carbohydrates) {
        this.carbohydrates.setTotalCarbohydrates(this.carbohydrates.getTotalCarbohydrates() + carbohydrates.getTotalCarbohydrates());
        this.carbohydrates.setFiber(this.carbohydrates.getFiber() + carbohydrates.getFiber());
        this.carbohydrates.setSugar(this.carbohydrates.getSugar() + carbohydrates.getSugar());
    }

    public void addProteins(Proteins proteins) {
        this.proteins.setTotalProteins(this.proteins.getTotalProteins() + proteins.getTotalProteins());
    }

    public void addFats(Fats fats) {
        this.fats.setTotalFats(this.fats.getTotalFats() + fats.getTotalFats());
        this.fats.setSaturatedFats(this.fats.getSaturatedFats() + fats.getTotalFats());
    }


}
