package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.Builder;
import lombok.Data;
import org.ectimel.dietgenerator.domain.model.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
