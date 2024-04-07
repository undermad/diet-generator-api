package org.ectimel.dietgenerator.domain.model;

import lombok.Data;
import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;

import java.util.ArrayList;
import java.util.List;

@Data
public class Diet {

    private List<Dish> dishes;
    private Nutrients nutrients;

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
}
