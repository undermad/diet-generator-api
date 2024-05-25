package org.ectimel.dietgenerator.presentation.api.dto;

import org.ectimel.dietgenerator.domain.model.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public record RecipeDto(
        UUID id,
        String name,
        Map<ProductDto, Double>ingredientsProportion,
        NutrientDto nutrients,
        Double basePortionInGrams,
        boolean isScalable,
        String howToPrepare,
        List<DietType>dietTypes,
        List<MealType> mealTypes,
        Set<Filler>scalableFillers
) {
}
