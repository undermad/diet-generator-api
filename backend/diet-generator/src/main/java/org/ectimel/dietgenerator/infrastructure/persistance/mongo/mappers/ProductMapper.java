package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.application.port.DomainMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductDocument;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DomainMapper<Product, ProductDocument> {

    private final NutrientMapper nutrientMapper;

    public ProductMapper(NutrientMapper nutrientMapper) {
        this.nutrientMapper = nutrientMapper;
    }


    @Override
    public Product mapToDomain(ProductDocument entityObject) {
        return Product.builder()
                .id(entityObject.getId())
                .name(entityObject.getName())
                .nutrients(nutrientMapper.mapToDomain(entityObject.getNutrientInformation()))
                .productType(entityObject.getProductType())
                .filler(entityObject.getFiller())
                .build();
    }

    @Override
    public ProductDocument mapFromDomain(Product domainObject) {
        return ProductDocument.builder()
                .id(domainObject.getId())
                .name(domainObject.getName())
                .productType(domainObject.getProductType())
                .filler(domainObject.getFiller())
                .nutrientInformation(nutrientMapper.mapFromDomain(domainObject.getNutrients()))
                .build();
    }

}
