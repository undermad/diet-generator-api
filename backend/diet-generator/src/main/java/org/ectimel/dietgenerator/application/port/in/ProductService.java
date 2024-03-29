package org.ectimel.dietgenerator.application.port.in;

import org.ectimel.dietgenerator.domain.model.Product;

public interface ProductService {
    Product saveProduct(Product product);
}
