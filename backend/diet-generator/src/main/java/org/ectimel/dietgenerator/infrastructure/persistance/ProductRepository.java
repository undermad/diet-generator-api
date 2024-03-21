package org.ectimel.dietgenerator.infrastructure.persistance;

import org.ectimel.dietgenerator.infrastructure.persistance.models.ProductDocument;

public interface ProductRepository {

    ProductDocument save(ProductDocument productDocument);

}
