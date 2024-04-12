package org.ectimel.dietgenerator.presentation.api.mapper;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.presentation.api.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    private final NutrientDtoMapper nutrientDtoMapper;

    public ProductDtoMapper(NutrientDtoMapper nutrientDtoMapper) {
        this.nutrientDtoMapper = nutrientDtoMapper;
    }

    public ProductDto mapFromDomain(Product product) {
        return new ProductDto(
                product.getId().toString(),
                product.getName(),
                nutrientDtoMapper.mapFromDomain(product.getNutrients())
                );
    }

}
