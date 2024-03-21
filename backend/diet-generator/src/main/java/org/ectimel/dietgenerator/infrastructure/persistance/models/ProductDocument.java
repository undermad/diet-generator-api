package org.ectimel.dietgenerator.infrastructure.persistance.models;

import lombok.Builder;
import lombok.Data;
import org.ectimel.dietgenerator.domain.model.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@Document(collection = "products")
public class ProductDocument {

    @Id
    private String id;

    private String name;
    private NutrientInformation nutrientInformation;
    private ProductType productType;
    private Filler filler;


    public Product mapToDomain() {
        return Product.builder()
                .name(this.name)
                .nutrients(new Nutrients(
                        new Calories(
                                BigDecimal.valueOf(this.nutrientInformation.getTotalCalories())),
                        new Carbohydrates(
                                BigDecimal.valueOf(this.nutrientInformation.getTotalCarbohydrates()),
                                BigDecimal.valueOf(this.nutrientInformation.getFiber()),
                                BigDecimal.valueOf(this.nutrientInformation.getFiber())),
                        new Proteins(
                                BigDecimal.valueOf(this.nutrientInformation.getTotalProteins())),
                        new Fats(
                                BigDecimal.valueOf(this.nutrientInformation.getTotalFats()),
                                BigDecimal.valueOf(this.nutrientInformation.getSaturatedFats()))))
                .productType(this.productType)
                .filler(this.filler)
                .build();
    }



}
