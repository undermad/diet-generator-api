package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.infrastructure.init.RecipeInit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {


    private final RecipeInit recipeInit;

    public DietGeneratorApplication(RecipeInit recipeInit) {
        this.recipeInit = recipeInit;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        recipeInit.initRecipesFromFile();
    }
}
