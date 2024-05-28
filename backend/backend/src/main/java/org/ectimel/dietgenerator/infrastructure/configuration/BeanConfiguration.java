package org.ectimel.dietgenerator.infrastructure.configuration;

import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.application.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productCRUD(ProductRepository productRepository) {
        return new ProductCRUD(productRepository);
    }

    @Bean
    public RecipeService recipeCRUD(RecipeRepository recipeRepository) {
        return new RecipeCRUD(recipeRepository);
    }

    @Bean
    public CreateDiet dietService(RecipeRepository recipeRepository) {
        return new CreateDietUseCase(recipeRepository);
    }

    @Bean
    public CalculateTDEE calculateTDEE() {
        return new CalculateTDEEService();
    }

    @Bean
    public CalculateBMI calculateBMI() {
        return new CalculateBMIService();
    }
}
