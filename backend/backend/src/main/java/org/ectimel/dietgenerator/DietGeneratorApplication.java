package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.domain.model.Dish;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final TestInit testInit;

    @Qualifier("mongoRecipeRepositoryImpl")
    private final RecipeRepository recipeRepository;

    private final RecipeInit recipeInit;

    public DietGeneratorApplication(TestInit testInit, RecipeRepository recipeRepository, RecipeInit recipeInit) {
        this.testInit = testInit;
        this.recipeRepository = recipeRepository;
        this.recipeInit = recipeInit;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        recipeInit.initRecipesFromFile();

//        testInit.printBmi();
//        testInit.initProductsFromFile();
//
//        Recipe ryzZKurwczakiem = testInit.initRyzZKurwczakiem();
//        Recipe recipe = recipeRepository.save(ryzZKurwczakiem);
//
//        Recipe omlette = testInit.initBreakfast();
//        Recipe savedOmlette = recipeRepository.save(omlette);
//
//        Recipe cottageRadish = testInit.initDinner();
//        Recipe savedCottageRadish = recipeRepository.save(cottageRadish);
//
//        Dish dish = Dish.createDish(savedCottageRadish);
//        System.out.println("Calories in omlet dish: " + dish.getNutrients().getCalories().getTotalCalories());
//        System.out.println("Proteins: " + dish.getNutrients().getProteins().getTotalProteins());
//        System.out.println("Fats: " + dish.getNutrients().getFats().getTotalFats());
//        System.out.println("Carbohydrates: " + dish.getNutrients().getCarbohydrates().getTotalCarbohydrates());

    }
}
