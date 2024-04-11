package org.ectimel.dietgenerator.presentation.api.dto.request;

import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.generator.diet.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.diet.DietType;

import java.math.BigDecimal;

public record DietRequest(
        Integer requiredCalories,
        String dietType,
        Integer numberOfMeals,
        Double bodyWeightInKg,
        String gender
) {

    public DietAttributes mapToDomain() {
        return new DietAttributes(
                BigDecimal.valueOf(this.requiredCalories()),
                DietType.fromValue(this.dietType()),
                BigDecimal.valueOf(this.numberOfMeals()),
                BigDecimal.valueOf(this.bodyWeightInKg()),
                Gender.stringToGender(this.gender()));
    }
}
