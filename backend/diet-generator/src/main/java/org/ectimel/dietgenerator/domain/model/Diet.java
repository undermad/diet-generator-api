package org.ectimel.dietgenerator.domain.model;

import lombok.Data;
import org.ectimel.dietgenerator.domain.calculator.macro.Macronutrient;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Diet {

    private List<Dish> dishes;
    private Nutrients nutrients;
    private Map<String, Double> shoppingList;

    public Diet() {
        this.dishes = new ArrayList<>();
        this.nutrients = Nutrients.createEmptyNutrients();
    }

    public void addDish(Dish dish) {
        this.nutrients.addNutrients(dish.getNutrients());
        this.dishes.add(dish);
    }

    public List<Dish> getScalableDishesByFiller(Filler filler){
        List<Dish> scalableDishes = new ArrayList<>();
        this.dishes.forEach(dish -> {
            if(dish.getRecipe().getScalableFillers().contains(filler))
                scalableDishes.add(dish);
        });
        return scalableDishes;
    }

    public void reduceMacronutrient(Filler filler, BigDecimal amount, Macronutrient missingMacronutrients) {
        List<Dish> scalableDishes = getScalableDishesByFiller(filler);
        BigDecimal eachDishAmount = amount.divide(BigDecimal.valueOf(scalableDishes.size()), 2, RoundingMode.HALF_DOWN);
        for (Dish dish : scalableDishes) {
            Nutrients reducedNutrients = dish.reduceFiller(filler, eachDishAmount);
            missingMacronutrients.increaseValues(reducedNutrients);
            nutrients.subtractNutrients(reducedNutrients);
        }
    }

    public void increaseMacronutrient(Filler filler, BigDecimal amount, Macronutrient missingMacronutrients) {
        List<Dish> scalableDishes = getScalableDishesByFiller(filler);
        BigDecimal eachDishAmount = amount.divide(BigDecimal.valueOf(scalableDishes.size()), 2, RoundingMode.HALF_DOWN);
        for (Dish dish : scalableDishes) {
            Nutrients addedNutrients = dish.increaseFiller(filler, eachDishAmount);
            missingMacronutrients.reduceValues(addedNutrients);
            nutrients.addNutrients(addedNutrients);
        }
    }
}
