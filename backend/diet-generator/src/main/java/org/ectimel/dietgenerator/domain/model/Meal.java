package org.ectimel.dietgenerator.domain.model;

import java.math.BigDecimal;
import java.util.Map;

public class Meal {

    private Map<Recipe, BigDecimal> recipesToGrams;

    public Meal(Map<Recipe, BigDecimal> recipesToGrams) {
        this.recipesToGrams = recipesToGrams;
    }

}
