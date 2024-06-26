package org.ectimel.dietgenerator.presentation.mapper;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.nutrient.Nutrients;
import org.ectimel.dietgenerator.presentation.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    private final NutrientDtoMapper nutrientDtoMapper;

    public ProductDtoMapper(NutrientDtoMapper nutrientDtoMapper) {
        this.nutrientDtoMapper = nutrientDtoMapper;
    }

    public ProductDto mapFromDomain(Product product) {
        if(product == null) {
            return new ProductDto("", "", nutrientDtoMapper.mapFromDomain(Nutrients.createEmptyNutrients()));
        }
        return new ProductDto(
                product.getId().toString(),
                product.getName(),
                nutrientDtoMapper.mapFromDomain(product.getNutrients())
                );
    }

}
