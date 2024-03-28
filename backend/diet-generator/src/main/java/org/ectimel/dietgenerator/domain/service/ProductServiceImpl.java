package org.ectimel.dietgenerator.domain.service;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.port.in.ProductService;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;

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
