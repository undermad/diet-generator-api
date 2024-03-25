package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Document(collection = "recipes")
public class RecipeDocument extends MongoUUIDEntity{

    private String name;
    private List<ProductAmount> ingredientsProportion;
    private NutrientInformation nutrientInformation;
    private Double basePortion;
    private boolean isScalable;

}
