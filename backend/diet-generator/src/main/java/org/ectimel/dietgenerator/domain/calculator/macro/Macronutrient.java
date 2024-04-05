package org.ectimel.dietgenerator.domain.calculator.macro;

import lombok.Data;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;

@Data
public class Macronutrient {
    private BigDecimal calories;
    private BigDecimal proteins;
    private BigDecimal fats;
    private BigDecimal carbohydrates;

    public Macronutrient(BigDecimal calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public void reduceValues(Nutrients nutrients) {
        setCalories(calories.subtract(nutrients.getCalories().getTotalCalories()));
        setProteins(proteins.subtract(nutrients.getProteins().getTotalProteins()));
        setFats(fats.subtract(nutrients.getFats().getTotalFats()));
        setCarbohydrates(nutrients.getCarbohydrates().getTotalCarbohydrates());
    }




}
