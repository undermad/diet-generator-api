package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataMongoProductRepository extends MongoRepository<ProductDocument, UUID> {

    @Query("{ 'name' : ?0 }")
    Optional<ProductDocument> findByName(String name);

}
