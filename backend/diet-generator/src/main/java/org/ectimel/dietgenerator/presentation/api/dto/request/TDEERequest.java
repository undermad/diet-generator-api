package org.ectimel.dietgenerator.presentation.api.dto.request;


import org.ectimel.dietgenerator.domain.calculator.BMRAttributes;
import org.ectimel.dietgenerator.domain.calculator.Gender;
import org.ectimel.dietgenerator.domain.calculator.calories.ActiveLevel;

import java.math.BigDecimal;

public record TDEERequest(Double bodyWeight, Double height, Integer age, String gender, String activeLevel) {


    public BMRAttributes mapToDomain() {
        return BMRAttributes.builder()
                .bodyWeightInKg(BigDecimal.valueOf(bodyWeight))
                .heightInCm(BigDecimal.valueOf(height))
                .age(BigDecimal.valueOf(age))
                .activeLevel(ActiveLevel.fromString(activeLevel))
                .gender(Gender.stringToGender(gender))
                .build();
    }



}
