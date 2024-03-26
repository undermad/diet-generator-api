package org.ectimel.dietgenerator.domain.calculator;

import io.vavr.control.Try;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender stringToGender(String value) {
        return Try.of(() -> Gender.valueOf(value.toUpperCase())).getOrElse((Gender) null);
    }
}
