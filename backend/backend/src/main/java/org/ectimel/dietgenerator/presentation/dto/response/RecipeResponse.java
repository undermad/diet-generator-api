package org.ectimel.dietgenerator.presentation.dto.response;

import org.ectimel.dietgenerator.presentation.dto.RecipeDto;

import java.util.List;

public record RecipeResponse(List<RecipeDto> recipes) {
}
