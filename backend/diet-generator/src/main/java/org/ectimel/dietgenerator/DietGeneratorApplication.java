package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.calories_calculator.ActiveLevel;
import org.ectimel.dietgenerator.domain.calories_calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calories_calculator.Gender;
import org.ectimel.dietgenerator.domain.calories_calculator.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        Map<Product, BigDecimal> recipeProportion = Map.of(rice, BigDecimal.valueOf(80), chicken, BigDecimal.valueOf(20));


        System.out.println(rice);
        System.out.println(chicken);


        Recipe ryzZKurwczakiem = new Recipe(recipeProportion);

        System.out.println(ryzZKurwczakiem.getNutrients().getCalories().getTotalCalories().setScale(2, RoundingMode.HALF_UP));


        BMRAttributes bmrAttributes = BMRAttributes.builder()
                .bodyWeightInKg(new BigDecimal("110"))
                .heightInCm(new BigDecimal("174"))
                .age(new BigDecimal("30"))
                .activeLevel(ActiveLevel.MODERATELY_ACTIVE)
                .gender(Gender.MALE)
                .build();

        MifflinStJeorCalculator mifflinStJeorCalculator = new MifflinStJeorCalculator();

        System.out.println(mifflinStJeorCalculator
                .calculate(bmrAttributes)
                .calculateTDEE(bmrAttributes.getActiveLevel()));


    }
}
