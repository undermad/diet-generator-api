package org.ectimel.dietgenerator.application.repositories;

import org.ectimel.dietgenerator.domain.model.Product;

import java.util.UUID;

public interface ProductRepository {

    Product save(Product product);
    Product getProduct(String productName);
    Product getProduct(UUID uuid);

}
