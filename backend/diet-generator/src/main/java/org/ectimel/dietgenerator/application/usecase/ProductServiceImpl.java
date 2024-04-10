package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.application.port.in.ProductService;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.application.repositories.ProductRepository;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
