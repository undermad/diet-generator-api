package org.ectimel.dietgenerator.application.repositories;

import org.ectimel.dietgenerator.domain.model.Product;

public interface ProductRepository {

    Product save(Product productDocument);

}
