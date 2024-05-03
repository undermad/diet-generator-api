package org.ectimel.dietgenerator.infrastructure.configuration;

import org.ectimel.dietgenerator.application.port.in.CalculateBMI;
import org.ectimel.dietgenerator.application.port.in.CalculateTDEE;
import org.ectimel.dietgenerator.application.port.in.CreateDiet;
import org.ectimel.dietgenerator.application.port.in.ProductService;
import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.application.usecase.CalculateBMIService;
import org.ectimel.dietgenerator.application.usecase.CalculateTDEEService;
import org.ectimel.dietgenerator.application.usecase.CreateDietUseCase;
import org.ectimel.dietgenerator.application.usecase.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
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
