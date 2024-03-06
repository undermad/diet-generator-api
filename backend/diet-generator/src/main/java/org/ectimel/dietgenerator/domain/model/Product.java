package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Product {

    private String name;
    private ProductType productType;
    private Nutrients nutrients;

    public Double getCalories() {
        return this.nutrients.getKcal().calories();
    }


}
