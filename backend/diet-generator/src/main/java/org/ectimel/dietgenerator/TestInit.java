package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.calculator.bmi.BMICalculator;
import org.ectimel.dietgenerator.domain.calculator.bmi.ActiveLevel;
import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.calories.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.generator.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Component
public class TestInit {

    private final NinjaService ninjaService;

    @Value("classpath:products.txt")
    private Resource productsFile;


    public TestInit(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    public void initProductsFromFile() throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(productsFile.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] productInfo = line.split("/");
                String product = productInfo[0];
                Filler filler = productInfo.length > 1 ? Filler.valueOf(productInfo[1]) : Filler.NONE;
                ninjaService.saveProductFromNinjaApi(product, filler);
            }
        }

    }


    public Recipe initRyzZKurwczakiem() {

        Map<Product, BigDecimal> ryzZKurwczakiemprop = Map.of(
                ninjaService.saveProductFromNinjaApi("rice", Filler.CARBOHYDRATE), BigDecimal.valueOf(15),
                ninjaService.saveProductFromNinjaApi("chicken breast", Filler.PROTEIN), BigDecimal.valueOf(52),
                ninjaService.saveProductFromNinjaApi("tomato", Filler.NONE), BigDecimal.valueOf(15),
                ninjaService.saveProductFromNinjaApi("onion", Filler.NONE), BigDecimal.valueOf(15),
                ninjaService.saveProductFromNinjaApi("olive oil", Filler.FAT), BigDecimal.valueOf(3));

        return Recipe.builder()
                .name("Ryz z kurwiczkiem i kurwisalatka")
                .howToPrepare("Fry the chicken, boil the rice and grow you muscles, eat all vegetables and never skip legs day!")
                .dietType(List.of(DietType.PROTEIN))
                .mealTypes(List.of(MealType.LUNCH))
                .ingredientsProportion(ryzZKurwczakiemprop)
                .basePortion(BigDecimal.valueOf(500))
                .isScalable(true)
                .build();
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
