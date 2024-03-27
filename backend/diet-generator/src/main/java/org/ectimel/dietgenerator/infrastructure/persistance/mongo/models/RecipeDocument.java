package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Document(collection = "recipes")
public class RecipeDocument extends MongoUUIDEntity{

    private String name;
    private List<ProductAmount> ingredientsProportion;
    private NutrientInformation nutrientInformation;
    private Double basePortion;
    private boolean isScalable;
    private DietType dietType;
    private String howToPrepare;

}
