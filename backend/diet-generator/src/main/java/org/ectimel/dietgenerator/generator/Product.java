package org.ectimel.dietgenerator.generator;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Product {

    private String name;
    private ProductType productType;
    private Nutrients nutrients;

}
