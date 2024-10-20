package org.ectimel.dietgenerator.presentation.controller;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.application.usecase.ProductService;
import org.ectimel.dietgenerator.presentation.dto.ProductDto;
import org.ectimel.dietgenerator.presentation.dto.response.ProductResponse;
import org.ectimel.dietgenerator.presentation.mapper.ProductDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    public ProductController(ProductService productService, ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @GetMapping("/{productName}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String productName) {
        Product product = productService.getProduct(productName);
        ProductDto productDto = productDtoMapper.mapFromDomain(product);
        return ResponseEntity.ok(new ProductResponse(List.of(productDto)));
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getProductById(@RequestParam String id){
        UUID uuid = UUID.fromString(id);
        Product product = productService.getProduct(uuid);
        ProductDto productDto = productDtoMapper.mapFromDomain(product);
        return ResponseEntity.ok(new ProductResponse(List.of(productDto)));
    }

}
