package org.ectimel.dietgenerator.domain.generator;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Nutrients;
import org.ectimel.dietgenerator.domain.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Getter
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
        BigDecimal numberOfFillers = BigDecimal.valueOf(countFillers(filler));
        BigDecimal gramsFraction = grams.divide(numberOfFillers, 2, RoundingMode.HALF_DOWN);
        dishes.forEach(dish -> {
            if (dish.getRecipe().isScalable()) {
                Map<Product, BigDecimal> productToGrams = dish.getProductToGrams();
                productToGrams.forEach(((product, bigDecimal) -> {
                    if (product.getFiller() != null && product.getFiller().equals(filler)) {
                        BigDecimal currentGrams = productToGrams.get(product);
                        BigDecimal productGramsToAdd = product.calculateProductGrams(filler, gramsFraction);
                        productToGrams.put(product, currentGrams.add(productGramsToAdd));
                        nutrients.addNutrients(product.calculateNutrients(productGramsToAdd));
                    }
                }));
            }
        });

    }

    private int countFillers(Filler filler) {
        AtomicReference<Integer> allFillers = new AtomicReference<>(0);
        dishes.forEach(dish -> {
            if (dish.getRecipe().isScalable()) {
                dish.getProductToGrams().forEach(((product, currentGrams) -> {
                    if (product.getFiller() != null && product.getFiller().equals(filler))
                        allFillers.getAndSet(allFillers.get() + 1);
                }));
            }
        });
        return allFillers.get();
    }


}
