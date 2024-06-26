package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.model.Product;

import java.util.UUID;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProduct(String productName);
    Product getProduct(UUID uuid);
}
