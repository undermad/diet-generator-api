package org.ectimel.dietgenerator;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.ectimel.dietgenerator.infrastructure.init.RecipeInit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Fatatu",
                description = "Fatatu is diet generator api that will create adjusted to given criteria diet and provide shopping list.",
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/license/mit"
                ),
                contact = @Contact(
                        name = "Dominik Tworek",
                        email = "dtworek94@gmail.com"
                ),
                version = "1.0"
        ),
        externalDocs = @ExternalDocumentation(
                url = "https://github.com/undermad/diet-generator-api"
        )
)
public class DietGeneratorApplication implements CommandLineRunner {


    private final RecipeInit recipeInit;

    public DietGeneratorApplication(RecipeInit recipeInit) {
        this.recipeInit = recipeInit;
    }


    public static void main(String[] args) {
        SpringApplication.run(DietGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        recipeInit.initRecipesFromFile();
    }
}
