package org.ectimel.dietgenerator.infrastructure.configuration;

import org.ectimel.dietgenerator.application.port.in.DietService;
import org.ectimel.dietgenerator.application.port.in.ProductService;
import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.application.service.DietServiceImpl;
import org.ectimel.dietgenerator.application.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public DietService dietService(RecipeRepository recipeRepository) {
        return new DietServiceImpl(recipeRepository);
    }
    

}
