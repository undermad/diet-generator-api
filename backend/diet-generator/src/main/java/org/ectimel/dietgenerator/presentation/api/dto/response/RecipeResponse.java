package org.ectimel.dietgenerator.presentation.api.dto.response;

import org.ectimel.dietgenerator.presentation.api.dto.RecipeDto;

import java.util.List;

public record RecipeResponse(List<RecipeDto> recipes) {
}
