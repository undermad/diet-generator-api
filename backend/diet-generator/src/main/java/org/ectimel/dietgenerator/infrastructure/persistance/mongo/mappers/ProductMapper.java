package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.infrastructure.persistance.EntityMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.NutrientInformation;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductDocument;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper implements EntityMapper<Product, ProductDocument> {

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
    public ProductDocument mapToEntity(Product domainObject) {
        return ProductDocument.builder()
                .id(domainObject.getId())
                .name(domainObject.getName())
                .productType(domainObject.getProductType())
                .filler(domainObject.getFiller())
                .nutrientInformation(nutrientMapper.mapToEntity(domainObject.getNutrients()))
                .build();
    }

}
