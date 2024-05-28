package org.ectimel.dietgenerator.infrastructure.ninja;

import org.ectimel.dietgenerator.application.repositories.ProductRepository;
import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.application.usecase.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NinjaService {


    private NinjaApi ninjaApi;
    private ProductService productService;

    @Qualifier("mongoProductRepository")
    private final ProductRepository productRepository;

    public NinjaService(NinjaApi ninjaApi, ProductService productService, ProductRepository productRepository) {
        this.ninjaApi = ninjaApi;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public Product saveProductFromNinjaApi(String query, Filler filler) {
        Product product = ninjaApi.getNinjaItem(query).mapToProduct();
        if(!Filler.NONE.equals(filler)) product.setFiller(filler);
        return productService.saveProduct(product);
    }

    public Product getAndSaveIfNotExist(String name,Filler filler) {
        Product product = productRepository.getProduct(name);
        if(product != null) {
            product.setFiller(filler);
            return product;
        }
        return saveProductFromNinjaApi(name, filler);
    }


}
