package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.generator.Meal;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final NinjaApi ninjaApi;
    private final TestInit testInit;

    public DietGeneratorApplication(NinjaApi ninjaApi, TestInit testInit) {
        this.ninjaApi = ninjaApi;
        this.testInit = testInit;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testInit.printBmi();
        Recipe ryzZKurwczakiem = testInit.initRyzZKurwczakiem();
        Recipe onionTomatoSalad = testInit.initSalad();

        Dish ryzZKurwczakiemDish = Dish.createDish(ryzZKurwczakiem);
        ryzZKurwczakiemDish.getProductToGrams().forEach(((product, bigDecimal) -> {
            System.out.println(product.getName() + " " + bigDecimal.doubleValue());
        }));

        Dish salad = Dish.createDish(onionTomatoSalad);
        salad.getProductToGrams().forEach(((product, bigDecimal) -> {
            System.out.println(product.getName() + " " + bigDecimal.doubleValue());
        }));

        Meal meal = new Meal(List.of(ryzZKurwczakiemDish, salad));
        meal.getDishes().forEach(dish -> {
            System.out.println(dish.getRecipe().getName());
            dish.getProductToGrams().forEach(((product, bigDecimal) -> {
                System.out.println("Product name: " + product.getName() + " " + bigDecimal.doubleValue() + " grams");
            }));
        });
        System.out.println("total carbo: " + meal.getNutrients().getCarbohydrates().getTotalCarbohydrates());
        System.out.println("total fat: " + meal.getNutrients().getFats().getTotalFats());

        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");

        System.out.println("FILLING IN PROGRESS!");
        meal.addFiller(Filler.CARBOHYDRATE, BigDecimal.valueOf(10));
        meal.addFiller(Filler.FAT, BigDecimal.valueOf(3));

        meal.getDishes().forEach(dish -> {
            System.out.println(dish.getRecipe().getName());
            dish.getProductToGrams().forEach(((product, bigDecimal) -> {
                System.out.println("Product name: " + product.getName() + " " + bigDecimal.doubleValue() + " grams");
            }));
        });

        System.out.println("total carbo: " + meal.getNutrients().getCarbohydrates().getTotalCarbohydrates());
        System.out.println("total fat: " + meal.getNutrients().getFats().getTotalFats());


    }
}
