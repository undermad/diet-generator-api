package org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.exceptions.ResourceNotFoundException;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.ProductMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Product getProduct(String productName) {
        Optional<ProductDocument> productDocument = productRepository.findByName(productName);
        return productDocument.map(productMapper::mapToDomain).orElse(null);
    }

    @Override
    public Product getProduct(UUID uuid) {
        ProductDocument productDocument = productRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Product with UUID: " + uuid + " not found."));
        return productMapper.mapToDomain(productDocument);
    }
}
