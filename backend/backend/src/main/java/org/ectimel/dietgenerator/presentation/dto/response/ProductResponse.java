package org.ectimel.dietgenerator.presentation.dto.response;

import org.ectimel.dietgenerator.presentation.dto.ProductDto;

import java.util.List;

public record ProductResponse(List<ProductDto> products) {
}
