package org.ectimel.dietgenerator.domain.model;

import java.util.List;

public class Meal {
    private List<Recipe> recipes;
    private Product proteinFiller;
    private Product fatFiller;
    private Product carbohydrateFiller;


    public Meal(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void findFillers() {

    }

    private Product findProteinFiller() {
        return null;
    }

    private Product findFatFiller() {
        return null;
    }

    private Product findCarbohydrateFiller() {
        return null;
    }

}
