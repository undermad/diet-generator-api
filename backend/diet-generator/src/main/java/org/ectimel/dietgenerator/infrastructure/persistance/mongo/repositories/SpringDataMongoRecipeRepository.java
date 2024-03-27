package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.RecipeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpringDataMongoRecipeRepository extends MongoRepository<RecipeDocument, UUID>{

    @Query("{ 'dietType' :  ?0 }")
    List<RecipeDocument> findAllByDietType(DietType dietType);

}
