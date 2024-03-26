package org.ectimel.dietgenerator.application.dto;

import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.generator.DietType;

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
