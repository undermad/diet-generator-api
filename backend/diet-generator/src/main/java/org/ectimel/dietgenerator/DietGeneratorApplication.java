package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.calories_calculator.BMICalculator;
import org.ectimel.dietgenerator.domain.calories_calculator.ActiveLevel;
import org.ectimel.dietgenerator.domain.calories_calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calories_calculator.Gender;
import org.ectimel.dietgenerator.domain.calories_calculator.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.Meal;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
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
        Map<Product, BigDecimal> ryzZKurwczakiemprop = Map.of(
                rice, BigDecimal.valueOf(25),
                chicken, BigDecimal.valueOf(75));
        Recipe ryzZKurwczakiem = new Recipe(ryzZKurwczakiemprop);
        ryzZKurwczakiem.setProteinFiller(chicken);


        Product tomato = ninjaApi.getNinjaItem("tomato").mapToProduct();
        Product onion = ninjaApi.getNinjaItem("onion").mapToProduct();
        Product oliveOil = ninjaApi.getNinjaItem("olive oil").mapToProduct();
        Map<Product, BigDecimal> saladProportion = Map.of(
                tomato, new BigDecimal("50"),
                onion, new BigDecimal("45"),
                oliveOil, new BigDecimal("5"));

        Recipe salad = new Recipe(saladProportion);
        salad.setFatFiller(oliveOil);

        Map<Recipe, BigDecimal> recipesToGrams = Map.of(
                ryzZKurwczakiem, new BigDecimal(400),
                salad, new BigDecimal(100));

        Meal kurwczakZRyzemITrawa = new Meal(recipesToGrams);


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

        BMICalculator bmiCalculator = new BMICalculator();

        System.out.println(bmiCalculator.calculate(bmrAttributes.getBodyWeightInKg(), bmrAttributes.getHeightInCm()));


    }
}
