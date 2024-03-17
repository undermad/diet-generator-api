package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.bmi_calculator.BMICalculator;
import org.ectimel.dietgenerator.domain.calories_calculator.ActiveLevel;
import org.ectimel.dietgenerator.domain.calories_calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calories_calculator.Gender;
import org.ectimel.dietgenerator.domain.calories_calculator.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class TestInit {

    private final NinjaApi ninjaApi;

    public TestInit(NinjaApi ninjaApi) {
        this.ninjaApi = ninjaApi;
    }


    public Recipe initSalad() {

        Product tomato = ninjaApi.getNinjaItem("tomato").mapToProduct();
        Product onion = ninjaApi.getNinjaItem("onion").mapToProduct();
        Product oliveOil = ninjaApi.getNinjaItem("olive oil").mapToProduct();
        oliveOil.setFiller(Filler.FAT);

        Map<Product, BigDecimal> saladProportion = Map.of(
                tomato, new BigDecimal("50"),
                onion, new BigDecimal("45"),
                oliveOil, new BigDecimal("5"));

        return new Recipe(saladProportion, new BigDecimal("200"));

    }

    public Recipe initRyzZKurwczakiem() {
        Product rice = ninjaApi.getNinjaItem("rice").mapToProduct();
        rice.setFiller(Filler.CARBOHYDRATE);

        Product chicken = ninjaApi.getNinjaItem("chicken").mapToProduct();
        chicken.setFiller(Filler.PROTEIN);

        Map<Product, BigDecimal> ryzZKurwczakiemprop = Map.of(
                rice, BigDecimal.valueOf(25),
                chicken, BigDecimal.valueOf(75));
        return new Recipe(ryzZKurwczakiemprop, new BigDecimal("400"));
    }

    public void printBmi() {
        BMRAttributes bmrAttributes = BMRAttributes.builder()
                .bodyWeightInKg(new BigDecimal("110"))
                .heightInCm(new BigDecimal("174"))
                .age(new BigDecimal("30"))
                .activeLevel(ActiveLevel.MODERATELY_ACTIVE)
                .gender(Gender.MALE)
                .build();

        MifflinStJeorCalculator mifflinStJeorCalculator = new MifflinStJeorCalculator();

        System.out.println("Required calories per day: " + mifflinStJeorCalculator
                .calculate(bmrAttributes)
                .calculateTDEE(bmrAttributes.getActiveLevel()));

        BMICalculator bmiCalculator = new BMICalculator();
        System.out.println("BMI" + bmiCalculator.calculate(bmrAttributes.getBodyWeightInKg(), bmrAttributes.getHeightInCm()));
    }

}
