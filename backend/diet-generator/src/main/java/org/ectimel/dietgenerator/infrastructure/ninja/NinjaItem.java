package org.ectimel.dietgenerator.infrastructure.ninja;

import lombok.ToString;
import org.ectimel.dietgenerator.domain.model.*;

@ToString
public class NinjaItem {
    public String name;
    public double calories;
    public int serving_size_g;
    public double fat_total_g;
    public int fat_saturated_g;
    public double protein_g;
    public int sodium_mg;
    public int potassium_mg;
    public int cholesterol_mg;
    public int carbohydrates_total_g;
    public double fiber_g;
    public double sugar_g;


    public Product mapToProduct() {
        return Product.builder()
                .name(this.name)
                .nutrients(Nutrients.builder()
                        .kcal(new Calories(this.calories))
                        .fats(new Fats(this.fat_total_g, (double) this.fat_saturated_g))
                        .carbohydrates(new Carbohydrates((double) this.carbohydrates_total_g, this.fiber_g, this.sugar_g))
                        .proteins(new Proteins(this.protein_g))
                        .build())
                .build();
    }
}


