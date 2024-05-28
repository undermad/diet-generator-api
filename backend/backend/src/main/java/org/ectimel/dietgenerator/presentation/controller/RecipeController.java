package org.ectimel.dietgenerator.presentation.controller;


import org.ectimel.dietgenerator.application.usecase.RecipeService;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.presentation.dto.RecipeDto;
import org.ectimel.dietgenerator.presentation.dto.response.RecipeResponse;
import org.ectimel.dietgenerator.presentation.mapper.RecipeDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeDtoMapper recipeDtoMapper;

    public RecipeController(RecipeService recipeService, RecipeDtoMapper recipeDtoMapper) {
        this.recipeService = recipeService;
        this.recipeDtoMapper = recipeDtoMapper;
    }

    @GetMapping("/{recipeName}")
    public ResponseEntity<RecipeResponse> getProductByName(@PathVariable String recipeName) {
        List<Recipe> recipeList = recipeService.getRecipe(recipeName);
        List<RecipeDto> recipeDto = recipeList
                .stream()
                .map(recipeDtoMapper::mapFromDomain)
                .toList();
        return ResponseEntity.ok(new RecipeResponse(recipeDto));
    }


}
