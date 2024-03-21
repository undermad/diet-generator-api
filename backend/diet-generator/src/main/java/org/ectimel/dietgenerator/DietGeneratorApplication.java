package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.ProductType;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.ectimel.dietgenerator.infrastructure.persistance.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.persistance.models.NutrientInformation;
import org.ectimel.dietgenerator.infrastructure.persistance.models.ProductDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final NinjaApi ninjaApi;
    private final TestInit testInit;

    @Qualifier("mongoProductRepository")
    private final ProductRepository productRepository;

    public DietGeneratorApplication(NinjaApi ninjaApi, TestInit testInit, ProductRepository productRepository) {
        this.ninjaApi = ninjaApi;
        this.testInit = testInit;
        this.productRepository = productRepository;
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


        System.out.println(ryzZKurwczakiemDish.getRecipe().getName());
        ryzZKurwczakiemDish.getProductToGrams().forEach(((product, bigDecimal) -> {
            System.out.println("Product name: " + product.getName() + " " + bigDecimal.doubleValue() + " grams");
        }));
        System.out.println("total carbo: " + ryzZKurwczakiemDish.getNutrients().getCarbohydrates().getTotalCarbohydrates());
        System.out.println("total fat: " + ryzZKurwczakiemDish.getNutrients().getFats().getTotalFats());

        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");

        System.out.println("FILLING IN PROGRESS!");
        ryzZKurwczakiemDish.addFiller(Filler.CARBOHYDRATE, BigDecimal.valueOf(10));
        ryzZKurwczakiemDish.addFiller(Filler.FAT, BigDecimal.valueOf(3));

        System.out.println(ryzZKurwczakiemDish.getRecipe().getName());
        ryzZKurwczakiemDish.getProductToGrams().forEach(((product, bigDecimal) -> {
            System.out.println("Product name: " + product.getName() + " " + bigDecimal.doubleValue() + " grams");
        }));

        System.out.println("total carbo: " + ryzZKurwczakiemDish.getNutrients().getCarbohydrates().getTotalCarbohydrates());
        System.out.println("total fat: " + ryzZKurwczakiemDish.getNutrients().getFats().getTotalFats());

        ProductDocument potatoDocument = ProductDocument.builder()
                .name("Potato")
                .productType(ProductType.VEGETABLE)
                .filler(Filler.CARBOHYDRATE)
                .nutrientInformation(NutrientInformation.builder()
                        .totalCalories(77)
                        .totalCarbohydrates(17.47)
                        .fiber(0)
                        .sugar(0)
                        .totalProteins(2.02)
                        .totalFats(0.09)
                        .saturatedFats(0)
                        .build())
                .build();

        Product potato = potatoDocument.mapToDomain();
        System.out.println(potato.getNutrients().getCalories().getTotalCalories());

        productRepository.save(potatoDocument);



    }
}
