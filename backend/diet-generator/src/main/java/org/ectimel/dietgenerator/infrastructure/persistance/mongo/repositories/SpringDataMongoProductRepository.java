package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoProductRepository extends MongoRepository<ProductDocument, UUID> {
}
