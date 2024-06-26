package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.application.repositories.ProductRepository;

import java.util.UUID;

public class ProductCRUDUseCase implements ProductService {

    private final ProductRepository productRepository;

    public ProductCRUDUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(String productName) {
        return productRepository.getProduct(productName);
    }

    @Override
    public Product getProduct(UUID uuid) {
        return productRepository.getProduct(uuid);
    }


}
