package org.ectimel.dietgenerator.presentation.mapper;

import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.presentation.dto.RecipeDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeDtoMapper {

    private final NutrientDtoMapper nutrientDtoMapper;
    private final ProductDtoMapper productDtoMapper;

    public RecipeDtoMapper(NutrientDtoMapper nutrientDtoMapper, ProductDtoMapper productDtoMapper) {
        this.nutrientDtoMapper = nutrientDtoMapper;
        this.productDtoMapper = productDtoMapper;
    }

    public RecipeDto mapFromDomain(Recipe recipe) {
        if (recipe == null) return null;

        return new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.getIngredientsProportion()
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                entry -> productDtoMapper.mapFromDomain(entry.getKey()),
                                entry -> entry.getValue().doubleValue())),
                nutrientDtoMapper.mapFromDomain(recipe.getNutrients()),
                recipe.getBasePortionInGrams().doubleValue(),
                recipe.isScalable(),
                recipe.getHowToPrepare(),
                recipe.getDietTypes(),
                recipe.getMealTypes(),
                recipe.getScalableFillers()
        );
    }

}
