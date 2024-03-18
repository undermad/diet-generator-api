package org.ectimel.dietgenerator.domain.generator;

import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Nutrients;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Meal {

    private List<Dish> dishes;
    private Nutrients nutrients;

    public Meal(List<Dish> dishes) {
        this.dishes = dishes;
        this.nutrients = calculateNutrients();
    }

    private Nutrients calculateNutrients() {
        Nutrients calculatedNutrients = Nutrients.createEmptyNutrients();
        this.dishes.forEach(dish -> calculatedNutrients.addNutrients(dish.getNutrients()));
        return calculatedNutrients;
    }

    public void addFiller(Filler filler, BigDecimal grams) {
        int allFillers = countFillers(filler);

    }

    private int countFillers(Filler filler) {
        AtomicReference<Integer> allFillers = new AtomicReference<>(0);
        dishes.forEach(dish -> {
            dish.getRecipesToGrams().forEach(((product, currentGrams) -> {
                if (product.getFiller().equals(filler))
                    allFillers.getAndSet(allFillers.get() + 1);
            }));
        });
        return allFillers.get();
    }


}
