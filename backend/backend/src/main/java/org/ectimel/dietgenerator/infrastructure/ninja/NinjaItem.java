package org.ectimel.dietgenerator.infrastructure.ninja;

import lombok.ToString;
import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.domain.model.nutrient.*;

import java.math.BigDecimal;

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
        System.out.println(this.name + " " + this.fat_total_g);
        return Product.builder()
                .name(this.name)
                .filler(Filler.NONE)
                .nutrients(Nutrients.builder()
                        .calories(new Calories(new BigDecimal(this.calories)))
                        .fats(new Fats(new BigDecimal(this.fat_total_g), new BigDecimal(fat_saturated_g)))
                        .carbohydrates(new Carbohydrates(new BigDecimal(carbohydrates_total_g), new BigDecimal(fiber_g), new BigDecimal(sugar_g)))
                        .proteins(new Proteins(new BigDecimal(protein_g)))
                        .build())
                .build();
    }
}


