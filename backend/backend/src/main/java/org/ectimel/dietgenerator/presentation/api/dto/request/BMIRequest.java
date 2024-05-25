package org.ectimel.dietgenerator.presentation.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BMIRequest(

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 999,  message = "Your weight is to big.")
        @NotNull(message = "Can not be empty")
        Double bodyWeightInKg,

        @Min(value = 0, message = "Value can not be less than 0.")
        @Max(value = 260,  message = "Your heightInCm is to high")
        @NotNull(message = "Can not be empty")
        Double heightInCm
) {
}
