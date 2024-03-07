package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final NinjaApi ninjaApi;

    public DietGeneratorApplication(NinjaApi ninjaApi) {
        this.ninjaApi = ninjaApi;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product rice = ninjaApi.getNinjaItem("rice").mapToProduct();
        Product chicken = ninjaApi.getNinjaItem("chicken").mapToProduct();
        Map<Product, Integer> recipeProportion = Map.of(rice, 80, chicken, 20);


        System.out.println(rice);
        System.out.println(chicken);


        Recipe recipe = new Recipe(recipeProportion);

        System.out.println(recipe);


    }
}
