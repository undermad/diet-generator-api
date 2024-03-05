package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.generator.Product;
import org.ectimel.dietgenerator.ninja.NinjaApi;
import org.ectimel.dietgenerator.ninja.NinjaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    private final NinjaApi ninjaApi;

    public DietGeneratorApplication(NinjaApi ninjaApi) {
        this.ninjaApi = ninjaApi;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product product = ninjaApi.getNinjaItem("Potato").mapToProduct();
        System.out.println(product);

    }
}
