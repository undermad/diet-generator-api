package org.ectimel.dietgenerator.domain.port.out;

import org.ectimel.dietgenerator.domain.model.Product;

public interface ProductRepository {

    Product save(Product productDocument);

}
