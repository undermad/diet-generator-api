package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.ProductMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mongoProductRepository")
public class MongoProductRepositoryImpl implements ProductRepository {

    private final SpringDataMongoProductRepository productRepository;
    private final ProductMapper productMapper;

    public MongoProductRepositoryImpl(SpringDataMongoProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductDocument savedProduct = productRepository.save(productMapper.mapFromDomain(product));
        return productMapper.mapToDomain(savedProduct);
    }
}
