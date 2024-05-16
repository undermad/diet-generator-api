package org.ectimel.dietgenerator.presentation.api.mapper;

import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.presentation.api.dto.response.DietResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.security.Key;
import java.util.stream.Collectors;

@Component
public class DietMapper {

    private final NutrientDtoMapper nutrientDtoMapper;
    private final DishMapper dishMapper;

    public DietMapper(NutrientDtoMapper nutrientDtoMapper, DishMapper dishMapper) {
        this.nutrientDtoMapper = nutrientDtoMapper;
        this.dishMapper = dishMapper;
    }

    public DietResponse mapToDietResponse(Diet diet) {
        return new DietResponse(
                diet.getDishes().stream()
                        .map(dishMapper::mapFromDomain)
                        .collect(Collectors.toList()),
                nutrientDtoMapper.mapFromDomain(diet.getNutrients()),
                diet.getShoppingList()
        );
    }
}
