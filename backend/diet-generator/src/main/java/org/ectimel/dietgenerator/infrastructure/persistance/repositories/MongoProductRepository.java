package org.ectimel.dietgenerator.infrastructure.persistance.repositories;

import org.ectimel.dietgenerator.infrastructure.persistance.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.models.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

@Qualifier("mongoProductRepository")
public interface MongoProductRepository extends ProductRepository, CrudRepository<ProductDocument, String> {

}
