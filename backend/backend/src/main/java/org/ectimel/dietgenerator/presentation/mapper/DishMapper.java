package org.ectimel.dietgenerator.presentation.mapper;

import org.ectimel.dietgenerator.domain.model.Dish;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.presentation.dto.DishDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Component
public class DishMapper {

    private final NutrientDtoMapper nutrientDtoMapper;


    public DishMapper(NutrientDtoMapper nutrientDtoMapper) {
        this.nutrientDtoMapper = nutrientDtoMapper;
    }

    public DishDto mapFromDomain(Dish domainObject) {
        return new DishDto(
                mapProductToGrams(domainObject.getProductToGrams()),
                domainObject.getRecipe().getName(),
                domainObject.getRecipe().getHowToPrepare(),
                nutrientDtoMapper.mapFromDomain(domainObject.getNutrients())
        );
    }

    private Map<String, Double> mapProductToGrams(Map<Product, BigDecimal> productToGrams) {
        Map<String, Double> nameToGrams = new HashMap<>();
        productToGrams.keySet().forEach(key -> {
            nameToGrams.put(key.getName(), productToGrams.get(key)
                    .setScale(1, RoundingMode.HALF_DOWN)
                    .doubleValue());
        });
        return nameToGrams;
    }
}
