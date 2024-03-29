package org.ectimel.dietgenerator.infrastructure.ninja;

import org.ectimel.dietgenerator.domain.model.Product;
import org.ectimel.dietgenerator.domain.model.nutrient.Filler;
import org.ectimel.dietgenerator.application.port.in.ProductService;
import org.springframework.stereotype.Component;

@Component
public class NinjaService {


    private NinjaApi ninjaApi;
    private ProductService productService;


    public NinjaService(NinjaApi ninjaApi, ProductService productService) {
        this.ninjaApi = ninjaApi;
        this.productService = productService;
    }

    public Product saveProductFromNinjaApi(String query, Filler filler) {
        Product product = ninjaApi.getNinjaItem(query).mapToProduct();
        if(!Filler.NONE.equals(filler)) product.setFiller(filler);
        return productService.saveProduct(product);
    }


}
