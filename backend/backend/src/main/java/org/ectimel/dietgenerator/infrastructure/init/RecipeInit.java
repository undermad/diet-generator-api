package org.ectimel.dietgenerator.infrastructure.init;

import lombok.Setter;
import org.ectimel.dietgenerator.application.repositories.RecipeRepository;
import org.ectimel.dietgenerator.domain.model.DietType;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.Recipe;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.infrastructure.ninja.NinjaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class RecipeInit {

    @Value("classpath:recipes.txt")
    private Resource recipesFile;

    private final NinjaService ninjaService;

    @Qualifier("mongoRecipeRepositoryImpl")
    private final RecipeRepository recipeRepository;

    public RecipeInit(NinjaService ninjaService, RecipeRepository recipeRepository) {
        this.ninjaService = ninjaService;
        this.recipeRepository = recipeRepository;
    }

    public void initRecipesFromFile() throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(recipesFile.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            RecipeParserValues recipe = new RecipeParserValues();
            while ((line = br.readLine()) != null) {
                if (line.equals("*")) {
                    recipe = new RecipeParserValues();
                    continue;
                }
                String[] choppedLine = line.split(":");
                switch (choppedLine[0]) {
                    case "Name" -> recipe.setName(choppedLine[1]);
                    case "HowTo" -> recipe.setHowToPrepare(choppedLine[1]);
                    case "DietType" -> {
                        List<DietType> listOfDietTypes = new ArrayList<>();
                        String[] choppedDietTypes = choppedLine[1].split("/");
                        for (String choppedDietType : choppedDietTypes) {
                            listOfDietTypes.add(DietType.fromValue(choppedDietType));
                        }
                        recipe.setDietTypes(listOfDietTypes);
                    }
                    case "MealType" -> {
                        List<MealType> listOfMealTypes = new ArrayList<>();
                        String[] choppedMealTypes = choppedLine[1].split("/");
                        for (String choppedMealType : choppedMealTypes) {
                            listOfMealTypes.add(MealType.fromValue(choppedMealType));
                        }
                        recipe.setMealTypes(listOfMealTypes);
                    }
                    case "Scalable" -> recipe.setScalable(choppedLine[1].equals("true"));
                    case "**" -> {
                        Map<Product, BigDecimal> ingredientsAmount = new HashMap<>();
                        String ingredient;
                        while (!(ingredient = br.readLine()).equals("**")) {

                            String[] choppedIngredient = ingredient.split(":");
                            String[] choppedRightSite = choppedIngredient[1].split("/");
                            String name = choppedIngredient[0];
                            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(choppedRightSite[0]));
                            Filler filler = Filler.fromValue(choppedRightSite[1]);
                            Product product = ninjaService.getAndSaveIfNotExist(name, filler);
                            ingredientsAmount.put(product, amount);
                        }
                        recipe.setBasePortionInGrams(calculateSum(ingredientsAmount));
                        recipe.setIngredientsProportion(calculateProportion(ingredientsAmount));
                    }
                    case "***" -> {
                        if (recipeRepository.findByName(recipe.name).isEmpty()) {
                            recipeRepository.save(recipe.mapToDomain());
                        }
                    }
                    
                }
            }
            
        }
        
    }


    private Map<Product, BigDecimal> calculateProportion(Map<Product, BigDecimal> productToAmount) {
        BigDecimal onePercentValue = calculateOnePercentValue(productToAmount);
        Map<Product, BigDecimal> ingredientProportion = new HashMap<>();
        productToAmount.forEach((product, amount) -> {
            BigDecimal percentage = amount.divide(onePercentValue, 1, RoundingMode.HALF_DOWN);
            ingredientProportion.put(product, percentage);
        });

        return adjustOffSet(ingredientProportion);
    }

    private Map<Product, BigDecimal> adjustOffSet(Map<Product, BigDecimal> ingredientProportion) {
        BigDecimal percentageOffSet = BigDecimal.valueOf(100).subtract(calculateSum(ingredientProportion));
        Product product = ingredientProportion.keySet().iterator().next();
        for (Map.Entry<Product, BigDecimal> entry : ingredientProportion.entrySet()) {
            if (entry.getValue().doubleValue() > percentageOffSet.doubleValue()) {
                product = entry.getKey();
                break;
            }
        }
        ingredientProportion.put(product, ingredientProportion.get(product).add(percentageOffSet));

        return ingredientProportion;
    }

    private BigDecimal calculateOnePercentValue(Map<Product, BigDecimal> productToAmount) {
        BigDecimal sum = calculateSum(productToAmount);
        return sum.divide(BigDecimal.valueOf(100), 1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateSum(Map<Product, BigDecimal> productToAmount) {
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        productToAmount.values().forEach(value -> sum.updateAndGet(v -> (v + value.doubleValue())));
        return BigDecimal.valueOf(sum.get());
    }

    @Setter
    private static class RecipeParserValues {
        private String name;
        private String howToPrepare;
        private List<DietType> dietTypes;
        private List<MealType> mealTypes;
        private Map<Product, BigDecimal> ingredientsProportion;
        private boolean isScalable;
        private BigDecimal basePortionInGrams;


        public Recipe mapToDomain() {
            return Recipe.builder()
                    .name(this.name)
                    .howToPrepare(this.howToPrepare)
                    .dietType(this.dietTypes)
                    .mealTypes(this.mealTypes)
                    .ingredientsProportion(this.ingredientsProportion)
                    .isScalable(this.isScalable)
                    .basePortionInGrams(this.basePortionInGrams)
                    .build();
        }
    }

}

