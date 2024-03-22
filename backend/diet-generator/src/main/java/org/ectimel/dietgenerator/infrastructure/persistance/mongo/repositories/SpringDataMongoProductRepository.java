package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductDocument;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataMongoProductRepository extends CrudRepository<ProductDocument, String> {
}
