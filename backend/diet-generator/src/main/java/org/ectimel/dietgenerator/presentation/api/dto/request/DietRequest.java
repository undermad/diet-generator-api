package org.ectimel.dietgenerator.presentation.api.dto.request;

import jakarta.validation.constraints.*;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.generator.diet.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.diet.DietType;

import java.math.BigDecimal;

public record DietRequest(
        
        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 16000,  message = "Value can not be more than 16000.")
        @NotNull(message = "Can not be empty")
        Integer kcal,

        @Size(max = 100, message = "Diet not supported")
        @NotEmpty(message = "Can not be empty")
        String dietType,

        @Min(value = 2, message = "Value can not be less than 2.")
        @Max(value = 12,  message = "Value can not be more than 12.")
        @NotNull(message = "Can not be empty")
        Integer numberOfMeals,

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 999,  message = "Your bodyWeightInKg is to big.")
        @NotNull(message = "Can not be empty")
        Double bodyWeightInKg,
        
        @Size(max = 100, message = "Choose valid gender.")
        @NotEmpty(message = "Can not be empty")
        String gender
) {

    public DietAttributes mapToDomain() {
        return new DietAttributes(
                BigDecimal.valueOf(this.kcal()),
                DietType.fromValue(this.dietType()),
                BigDecimal.valueOf(this.numberOfMeals()),
                BigDecimal.valueOf(this.bodyWeightInKg()),
                Gender.stringToGender(this.gender()));
    }
}
