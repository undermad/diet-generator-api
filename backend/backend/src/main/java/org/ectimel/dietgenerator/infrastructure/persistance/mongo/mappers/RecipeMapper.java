package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductAmount;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.RecipeDocument;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

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
        Recipe recipe = new Recipe();
        recipe.setId(entityObject.getId());
        recipe.setName(entityObject.getName());
        recipe.setHowToPrepare(entityObject.getHowToPrepare());
        recipe.setDietTypes(entityObject.getDietTypes());
        recipe.setNutrients(nutrientMapper.mapToDomain(entityObject.getNutrientInformation()));
        recipe.setScalable(entityObject.isScalable());
        recipe.setMealTypes(entityObject.getMealTypes());
        recipe.setBasePortionInGrams(BigDecimal.valueOf(entityObject.getBasePortionInGrams()));
        recipe.setIngredientsProportion(mapProductProportionToDomain(entityObject.getIngredientsProportion()));
        recipe.setScalableFillers(new HashSet<>(entityObject.getScalableFillers()));
        return recipe;
    }

    @Override
    public RecipeDocument mapFromDomain(Recipe domainObject) {
        return RecipeDocument.builder()
                .id(domainObject.getId())
                .name(domainObject.getName())
                .howToPrepare(domainObject.getHowToPrepare())
                .dietTypes(domainObject.getDietTypes())
                .mealTypes(domainObject.getMealTypes())
                .ingredientsProportion(mapProductProportionToEntity(domainObject.getIngredientsProportion()))
                .nutrientInformation(nutrientMapper.mapFromDomain(domainObject.getNutrients()))
                .isScalable(domainObject.isScalable())
                .basePortionInGrams(domainObject.getBasePortionInGrams().doubleValue())
                .scalableFillers(domainObject.getScalableFillers().stream().toList())
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
