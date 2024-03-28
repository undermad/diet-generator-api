package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.ProductType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.out.RecipeRepository;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers.ProductMapper;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.NutrientInformation;
import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final TestInit testInit;
    @Qualifier("mongoRecipeRepositoryImpl")
    private final RecipeRepository recipeRepository;


    public DietGeneratorApplication(TestInit testInit, RecipeRepository recipeRepository) {
        this.testInit = testInit;
        this.recipeRepository = recipeRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        testInit.printBmi();
//        testInit.initProductsFromFile();

        Recipe ryzZKurwczakiem = testInit.initRyzZKurwczakiem();
        Recipe recipe = recipeRepository.save(ryzZKurwczakiem);


    }
}
