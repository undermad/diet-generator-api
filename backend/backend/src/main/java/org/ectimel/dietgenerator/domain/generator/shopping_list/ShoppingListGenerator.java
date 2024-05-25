package org.ectimel.dietgenerator.domain.generator.shopping_list;

import org.ectimel.dietgenerator.domain.generator.Generator;
import org.ectimel.dietgenerator.domain.model.Diet;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public interface ShoppingListGenerator extends Generator {

    static Map<String, Double> generateShoppingList(Diet diet) {
        Map<String, Double> shoppingList = new HashMap<>();

        diet.getDishes().forEach((dish -> {
            dish.getProductToGrams().forEach((product, grams) -> {
                Double currentValue = shoppingList.get(product.getName());
                double valueToAdd = grams.setScale(1, RoundingMode.HALF_UP).doubleValue();
                if(currentValue != null) {
                    valueToAdd += currentValue;
                }
                shoppingList.put(product.getName(), valueToAdd);
            });
        }));
        return shoppingList;
    }

}
