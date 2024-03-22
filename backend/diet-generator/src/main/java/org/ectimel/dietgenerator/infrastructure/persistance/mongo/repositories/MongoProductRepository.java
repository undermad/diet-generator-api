package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.ProductMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mongoProductRepository")
public class MongoProductRepository implements ProductRepository {

    private final SpringDataMongoProductRepository productRepository;
    private final ProductMapper productMapper;

    public MongoProductRepository(SpringDataMongoProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductDocument savedProduct = productRepository.save(productMapper.mapToEntity(product));
        return productMapper.mapToDomain(savedProduct);
    }
}
