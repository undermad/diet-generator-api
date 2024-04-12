package org.ectimel.dietgenerator.presentation.api.dto.response;

import org.ectimel.dietgenerator.presentation.api.dto.ProductDto;

import java.util.List;

public record ProductResponse(List<ProductDto> products) {
}
