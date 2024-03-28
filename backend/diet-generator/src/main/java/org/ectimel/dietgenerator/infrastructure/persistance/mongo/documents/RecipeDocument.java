package org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
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
    private Double basePortionInGrams;
    private boolean isScalable;
    private String howToPrepare;
    private List<DietType> dietTypes;
    private List<MealType> mealTypes;

}
