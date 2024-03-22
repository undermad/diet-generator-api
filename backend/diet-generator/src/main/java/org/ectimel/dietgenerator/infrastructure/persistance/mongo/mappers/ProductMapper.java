package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.infrastructure.persistance.DatabaseMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.NutrientInformation;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.ProductDocument;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper implements DatabaseMapper<Product, ProductDocument> {


    @Override
    public Product mapToDomain(ProductDocument entityObject) {
        return Product.builder()
                .name(entityObject.getName())
                .nutrients(new Nutrients(
                        new Calories(
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getTotalCalories())),
                        new Carbohydrates(
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getTotalCarbohydrates()),
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getFiber()),
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getFiber())),
                        new Proteins(
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getTotalProteins())),
                        new Fats(
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getTotalFats()),
                                BigDecimal.valueOf(entityObject.getNutrientInformation().getSaturatedFats()))))
                .productType(entityObject.getProductType())
                .filler(entityObject.getFiller())
                .build();
    }

    @Override
    public ProductDocument mapToEntity(Product domainObject) {
        return ProductDocument.builder()
                .name(domainObject.getName())
                .productType(domainObject.getProductType())
                .filler(domainObject.getFiller())
                .nutrientInformation(NutrientInformation.builder()
                        .totalCalories(domainObject.getNutrients().getCalories().getTotalCalories().doubleValue())
                        .totalCarbohydrates(domainObject.getNutrients().getCarbohydrates().getTotalCarbohydrates().doubleValue())
                        .fiber(domainObject.getNutrients().getCarbohydrates().getFiber().doubleValue())
                        .sugar(domainObject.getNutrients().getCarbohydrates().getTotalCarbohydrates().doubleValue())
                        .totalFats(domainObject.getNutrients().getFats().getTotalFats().doubleValue())
                        .saturatedFats(domainObject.getNutrients().getFats().getSaturatedFats().doubleValue())
                        .build())
                .build();
    }

}
