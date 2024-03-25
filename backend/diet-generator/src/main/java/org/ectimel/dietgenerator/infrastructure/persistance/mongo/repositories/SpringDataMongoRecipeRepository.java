package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.RecipeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoRecipeRepository extends MongoRepository<RecipeDocument, UUID>{
}
