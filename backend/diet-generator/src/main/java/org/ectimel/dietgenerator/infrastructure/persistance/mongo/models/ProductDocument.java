package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.ectimel.dietgenerator.domain.model.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@Document(collection = "products")
public class ProductDocument extends MongoUUIDEntity {

    private String name;
    private NutrientInformation nutrientInformation;
    private ProductType productType;
    private Filler filler;

}
