package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.DomainMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductAmount;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.RecipeDocument;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecipeMapper implements DomainMapper<Recipe, RecipeDocument> {

    private final NutrientMapper nutrientMapper;
    private final ProductMapper productMapper;


    public RecipeMapper(NutrientMapper nutrientMapper, ProductMapper productMapper) {
        this.nutrientMapper = nutrientMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Recipe mapToDomain(RecipeDocument entityObject) {
        return Recipe.builder()
                .id(entityObject.getId())
                .name(entityObject.getName())
                .ingredientsProportion(mapProductProportionToDomain(entityObject.getIngredientsProportion()))
                .nutrients(nutrientMapper.mapToDomain(entityObject.getNutrientInformation()))
                .isScalable(entityObject.isScalable())
                .basePortion(BigDecimal.valueOf(entityObject.getBasePortion()))
                .build();

    }

    @Override
    public RecipeDocument mapFromDomain(Recipe domainObject) {
        return RecipeDocument.builder()
                .id(domainObject.getId())
                .name(domainObject.getName())
                .ingredientsProportion(mapProductProportionToEntity(domainObject.getIngredientsProportion()))
                .nutrientInformation(nutrientMapper.mapFromDomain(domainObject.getNutrients()))
                .isScalable(domainObject.isScalable())
                .basePortion(domainObject.getBasePortion().doubleValue())
                .build();
    }


    private List<ProductAmount> mapProductProportionToEntity(Map<Product, BigDecimal> proportionMap) {
        List<ProductAmount> productsProportions = new ArrayList<>();
        proportionMap.forEach(((product, percentage) -> {
            productsProportions.add(new ProductAmount(productMapper.mapFromDomain(product), percentage.doubleValue()));
        }));
        return productsProportions;
    }

    private Map<Product, BigDecimal> mapProductProportionToDomain(List<ProductAmount> productsProportions) {
        Map<Product, BigDecimal> domainMap = new HashMap<>();
        productsProportions.forEach((productAmount -> {
            domainMap.put(productMapper.mapToDomain(productAmount.getProduct()), BigDecimal.valueOf(productAmount.getPercentage()));
        }));
        return domainMap;
    }


}
