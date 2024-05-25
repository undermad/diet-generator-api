package org.ectimel.dietgenerator.presentation.api.dto.request;


import jakarta.validation.constraints.*;
import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.calories.ActiveLevel;

import java.math.BigDecimal;

public record TDEERequest(

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 999,  message = "Your bodyWeightInKg is to big.")
        @NotNull(message = "Can not be empty")
        Double bodyWeightInKg,

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 260,  message = "Your heightInCm is to high")
        @NotNull(message = "Can not be empty")
        Double heightInCm,

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 110,  message = "Whooa! Your age is over 110!")
        @NotNull(message = "Can not be empty")
        Integer age,

        @Size(max = 100, message = "Choose valid gender.")
        @NotEmpty(message = "Can not be empty")
        String gender,

        @Size(max = 100, message = "Choose valid activity level.")
        @NotEmpty(message = "Can not be empty")
        String activityLevel

) {


    public BMRAttributes mapToDomain() {
        return BMRAttributes.builder()
                .bodyWeightInKg(BigDecimal.valueOf(bodyWeightInKg))
                .heightInCm(BigDecimal.valueOf(heightInCm))
                .age(BigDecimal.valueOf(age))
                .activeLevel(ActiveLevel.fromString(activityLevel))
                .gender(Gender.stringToGender(gender))
                .build();
    }



}
