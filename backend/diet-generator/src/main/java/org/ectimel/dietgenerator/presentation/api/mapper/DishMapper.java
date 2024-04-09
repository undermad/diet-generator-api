package org.ectimel.dietgenerator.presentation.api.mapper;

import org.ectimel.dietgenerator.domain.generator.Dish;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.presentation.api.dto.DishDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DishMapper {

    private NutrientDtoMapper nutrientDtoMapper;


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
            nameToGrams.put(key.getName(), productToGrams.get(key).doubleValue());
        });
        return nameToGrams;
    }
}
