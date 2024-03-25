package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

import org.ectimel.dietgenerator.domain.model.*;
import org.ectimel.dietgenerator.infrastructure.persistance.EntityMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.models.NutrientInformation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NutrientMapper implements EntityMapper<Nutrients, NutrientInformation> {

    @Override
    public Nutrients mapToDomain(NutrientInformation entityObject) {
        return Nutrients.builder()
                .calories(new Calories(
                        BigDecimal.valueOf(entityObject.getTotalCalories())))
                .carbohydrates(new Carbohydrates(
                        BigDecimal.valueOf(entityObject.getTotalCarbohydrates()),
                        BigDecimal.valueOf(entityObject.getFiber()),
                        BigDecimal.valueOf(entityObject.getFiber())))
                .proteins(new Proteins(
                        BigDecimal.valueOf(entityObject.getTotalProteins()))).fats(new Fats(
                        BigDecimal.valueOf(entityObject.getTotalFats()),
                        BigDecimal.valueOf(entityObject.getSaturatedFats())))
                .build();
    }

    @Override
    public NutrientInformation mapToEntity(Nutrients domainObject) {
        return NutrientInformation.builder()
                .totalCalories(domainObject.getCalories().getTotalCalories().doubleValue())
                .totalCarbohydrates(domainObject.getCarbohydrates().getTotalCarbohydrates().doubleValue())
                .fiber(domainObject.getCarbohydrates().getFiber().doubleValue())
                .sugar(domainObject.getCarbohydrates().getTotalCarbohydrates().doubleValue())
                .totalFats(domainObject.getFats().getTotalFats().doubleValue())
                .saturatedFats(domainObject.getFats().getSaturatedFats().doubleValue())
                .build();
    }
}
