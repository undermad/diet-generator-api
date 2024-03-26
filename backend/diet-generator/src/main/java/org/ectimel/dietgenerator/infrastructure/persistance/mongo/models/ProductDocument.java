package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Document(collection = "products")
public class ProductDocument extends MongoUUIDEntity {

    private String name;
    private NutrientInformation nutrientInformation;
    private ProductType productType;
    private Filler filler;

}
