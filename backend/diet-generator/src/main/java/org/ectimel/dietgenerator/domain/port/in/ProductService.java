package org.ectimel.dietgenerator.domain.port.in;

import org.ectimel.dietgenerator.domain.model.Product;

public interface ProductService {
    Product createProduct(Product product);
}
