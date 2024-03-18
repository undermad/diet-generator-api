package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

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
        ryzZKurwczakiemDish.getRecipesToGrams().forEach(((product, bigDecimal) -> {
            System.out.println(product.getName() + " " + bigDecimal.doubleValue());
        }));

        Dish salad = Dish.createDish(onionTomatoSalad);
        salad.getRecipesToGrams().forEach(((product, bigDecimal) -> {
            System.out.println(product.getName() + " " + bigDecimal.doubleValue());
        }));



    }
}
