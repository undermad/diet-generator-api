package org.ectimel.dietgenerator.infrastructure.configuration;

import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.application.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RecipeService recipeRepository(RecipeRepository recipeRepository) {
        return new RecipeCRUDUseCase(recipeRepository);
    }

    @Bean
    public ProductService productCRUD(ProductRepository productRepository) {
        return new ProductCRUDUseCase(productRepository);
    }


    @Bean
    public CreateDiet dietService(RecipeRepository recipeRepository) {
        return new CreateDietUseCase(recipeRepository);
    }

    @Bean
    public CalculateTDEE calculateTDEE() {
        return new CalculateTDEEUseCase();
    }

    @Bean
    public CalculateBMI calculateBMI() {
        return new CalculateBMIUseCase();
    }
}
