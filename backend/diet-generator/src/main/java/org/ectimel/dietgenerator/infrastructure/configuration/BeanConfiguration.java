package org.ectimel.dietgenerator.infrastructure.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import org.ectimel.dietgenerator.domain.port.in.ProductService;
import org.ectimel.dietgenerator.domain.port.out.ProductRepository;
import org.ectimel.dietgenerator.domain.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductService productService(ProductRepository productRepository){
        return new ProductServiceImpl(productRepository);
    }
    

}
