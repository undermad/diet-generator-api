package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.bmi_calculator.BMICalculator;
import org.ectimel.dietgenerator.domain.calories_calculator.ActiveLevel;
import org.ectimel.dietgenerator.domain.calories_calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calories_calculator.Gender;
import org.ectimel.dietgenerator.domain.calories_calculator.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.generator.Meal;
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
        rice.setFiller(Filler.CARBOHYDRATE);

        Product chicken = ninjaApi.getNinjaItem("chicken").mapToProduct();
        chicken.setFiller(Filler.PROTEIN);

        Map<Product, BigDecimal> ryzZKurwczakiemprop = Map.of(
                rice, BigDecimal.valueOf(25),
                chicken, BigDecimal.valueOf(75));
        Recipe ryzZKurwczakiem = new Recipe(ryzZKurwczakiemprop);


        Product tomato = ninjaApi.getNinjaItem("tomato").mapToProduct();
        Product onion = ninjaApi.getNinjaItem("onion").mapToProduct();
        Product oliveOil = ninjaApi.getNinjaItem("olive oil").mapToProduct();
        oliveOil.setFiller(Filler.FAT);

        Map<Product, BigDecimal> saladProportion = Map.of(
                tomato, new BigDecimal("50"),
                onion, new BigDecimal("45"),
                oliveOil, new BigDecimal("5"));
        Recipe salad = new Recipe(saladProportion);

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
