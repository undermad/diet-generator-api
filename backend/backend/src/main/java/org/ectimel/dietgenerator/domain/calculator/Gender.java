package org.ectimel.dietgenerator.domain.calculator;

import org.ectimel.dietgenerator.domain.exception.WrongInputException;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender stringToGender(String text) {
        if (text != null) {
            for (Gender gender : Gender.values()) {
                if (text.equalsIgnoreCase(gender.name())) {
                    return gender;
                }
            }
        }
        throw new WrongInputException("There are only 2 genders -> MALE and FEMALE");
    }
}
