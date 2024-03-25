package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.calculator.bmi.BMICalculator;
import org.ectimel.dietgenerator.domain.calculator.bmi.ActiveLevel;
import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.calories.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.Filler;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class TestInit {

    private final NinjaApi ninjaApi;

    @Qualifier("mongoProductRepositoryImpl")
    private final ProductRepository productRepository;

    public TestInit(NinjaApi ninjaApi, ProductRepository productRepository) {
        this.ninjaApi = ninjaApi;
        this.productRepository = productRepository;
    }


    public Recipe initSalad() {

        Product tomato = ninjaApi.getNinjaItem("tomato").mapToProduct();
        Product onion = ninjaApi.getNinjaItem("onion").mapToProduct();
        Product oliveOil = ninjaApi.getNinjaItem("olive oil").mapToProduct();
        oliveOil.setFiller(Filler.FAT);

        Product savedTomato = productRepository.save(tomato);
        Product savedOnion = productRepository.save(onion);
        Product savedOliveOil = productRepository.save(oliveOil);

        Map<Product, BigDecimal> saladProportion = Map.of(
                savedTomato, new BigDecimal("67"),
                savedOnion, new BigDecimal("30"),
                savedOliveOil, new BigDecimal("3"));

        return new Recipe(saladProportion, new BigDecimal("200"), true, "Kurwatka");

    }

    public Recipe initRyzZKurwczakiem() {
        Product rice = ninjaApi.getNinjaItem("rice").mapToProduct();
        rice.setFiller(Filler.CARBOHYDRATE);

        Product chicken = ninjaApi.getNinjaItem("chicken").mapToProduct();
        chicken.setFiller(Filler.PROTEIN);

        Product savedRice = productRepository.save(rice);
        Product savedChicken = productRepository.save(chicken);

        Map<Product, BigDecimal> ryzZKurwczakiemprop = Map.of(
                savedRice, BigDecimal.valueOf(25),
                savedChicken, BigDecimal.valueOf(75));
        return new Recipe(ryzZKurwczakiemprop, new BigDecimal("400"), true, "Ryz z kurwczakiem");
    }

    public void printBmi() {
        BMRAttributes bmrAttributes = BMRAttributes.builder()
                .bodyWeightInKg(new BigDecimal("120"))
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
