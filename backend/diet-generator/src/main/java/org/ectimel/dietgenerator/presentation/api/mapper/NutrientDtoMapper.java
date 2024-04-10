package org.ectimel.dietgenerator.presentation.api.mapper;

import org.ectimel.dietgenerator.domain.model.nutrient.*;
import org.ectimel.dietgenerator.presentation.api.dto.NutrientDto;
import org.springframework.stereotype.Component;


@Component
public class NutrientDtoMapper {

    public NutrientDto mapFromDomain(Nutrients domainObject) {
        return new NutrientDto(
                domainObject.getCalories().getTotalCalories().doubleValue(),
                domainObject.getCarbohydrates().getTotalCarbohydrates().doubleValue(),
                domainObject.getCarbohydrates().getFiber().doubleValue(),
                domainObject.getCarbohydrates().getSugar().doubleValue(),
                domainObject.getProteins().getTotalProteins().doubleValue(),
                domainObject.getFats().getTotalFats().doubleValue(),
                domainObject.getFats().getSaturatedFats().doubleValue()
        );
    }
}
