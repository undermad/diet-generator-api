package org.ectimel.dietgenerator;

import org.ectimel.dietgenerator.generator.NinjaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@SpringBootApplication
public class DietGeneratorApplication implements CommandLineRunner {

    @Value("${ninja-api-key}")
    private String ninjaApiKey;

    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        RestClient restClient = RestClient.create();

        String baseURI = "https://api.calorieninjas.com/v1/nutrition?query=";
        String query = "potato";
        String URI = baseURI + query;

        NinjaResponse ninjaResponse = restClient.get()
                .uri(URI)
                .header("X-Api-Key", ninjaApiKey)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(NinjaResponse.class);

        assert ninjaResponse != null;
        ninjaResponse.getItems().forEach(ninjaItem -> System.out.println(ninjaItem.calories));
    }
}
