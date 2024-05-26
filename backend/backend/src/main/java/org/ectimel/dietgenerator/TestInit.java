package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.domain.calculator.bmi.BMICalculator;
import org.ectimel.dietgenerator.domain.calculator.calories.ActiveLevel;
import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.calories.BMRCalculator;
import org.ectimel.dietgenerator.domain.calculator.calories.MifflinStJeorCalculator;
import org.ectimel.dietgenerator.domain.model.DietType;
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
                .basePortionInGrams(BigDecimal.valueOf(500))
                .isScalable(true)
                .build();
    }

    public Recipe initBreakfast() {

        Map<Product, BigDecimal> breakfastIngredients = Map.of(
                ninjaService.saveProductFromNinjaApi("tomato", Filler.NONE), BigDecimal.valueOf(33),
                ninjaService.saveProductFromNinjaApi("whole egg", Filler.NONE), BigDecimal.valueOf(25),
                ninjaService.saveProductFromNinjaApi("chives", Filler.NONE), BigDecimal.valueOf(0.35),
                ninjaService.saveProductFromNinjaApi("button mushroom", Filler.NONE), BigDecimal.valueOf(40),
                ninjaService.saveProductFromNinjaApi("butter", Filler.FAT), BigDecimal.valueOf(1.3),
                ninjaService.saveProductFromNinjaApi("basil", Filler.NONE), BigDecimal.valueOf(0.35)
        );
        return Recipe.builder()
                .name("Omelette")
                .howToPrepare("Prepare")
                .dietType(List.of(DietType.PROTEIN))
                .mealTypes(List.of(MealType.BREAKFAST))
                .ingredientsProportion(breakfastIngredients)
                .basePortionInGrams(BigDecimal.valueOf(756))
                .isScalable(true)
                .build();
    }

    public Recipe initDinner() {

        Map<Product, BigDecimal> mealIngredients = Map.of(
                ninjaService.saveProductFromNinjaApi("low fat cottage cheese", Filler.PROTEIN), BigDecimal.valueOf(37),
                ninjaService.saveProductFromNinjaApi("wholegrain bread", Filler.CARBOHYDRATE), BigDecimal.valueOf(17),
                ninjaService.saveProductFromNinjaApi("radish", Filler.NONE), BigDecimal.valueOf(15),
                ninjaService.saveProductFromNinjaApi("tomato", Filler.NONE), BigDecimal.valueOf(15),
                ninjaService.saveProductFromNinjaApi("greek style yogurt", Filler.FAT), BigDecimal.valueOf(13),
                ninjaService.saveProductFromNinjaApi("butter", Filler.FAT), BigDecimal.valueOf(2),
                ninjaService.saveProductFromNinjaApi("chives", Filler.NONE), BigDecimal.valueOf(1)
        );
        return Recipe.builder()
                .name("Cottage cheese with radish")
                .howToPrepare("Chop vegetable and mix all ingredients")
                .dietType(List.of(DietType.PROTEIN))
                .mealTypes(List.of(MealType.DINNER))
                .ingredientsProportion(mealIngredients)
                .basePortionInGrams(BigDecimal.valueOf(405))
                .isScalable(true)
                .build();
    }


    public void printBmi() {
        BMRAttributes bmrAttributes = BMRAttributes.builder()
                .bodyWeightInKg(new BigDecimal("120"))
                .heightInCm(new BigDecimal("174"))
                .age(new BigDecimal("30"))
                .gender(Gender.MALE)
                .build();

        BMRCalculator mifflinStJeorCalculator = new MifflinStJeorCalculator();

        System.out.println("Required calories per day: " + mifflinStJeorCalculator
                .calculate(bmrAttributes)
                .calculateTDEE(ActiveLevel.MODERATELY));

        System.out.println("BMI" + BMICalculator.calculate(bmrAttributes.getBodyWeightInKg(), bmrAttributes.getHeightInCm()));
    }

}
