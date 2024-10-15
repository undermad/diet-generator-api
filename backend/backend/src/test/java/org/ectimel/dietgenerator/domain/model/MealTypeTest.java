package org.ectimel.dietgenerator.domain.model;

import org.ectimel.dietgenerator.domain.exception.WrongInputException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class MealTypeTest {

    @Test
    void fromValue_wrongValues() {
        assertThrows(WrongInputException.class, () -> {

            MealType.fromValue(null);
        }, "Should throw IllegalArgumentException");

        assertThrows(WrongInputException.class, () -> {

            MealType.fromValue("Abc");
        }, "Should throw IllegalArgumentException");
    }

    @Test
    void fromValue_correctValue() {
        assertEquals(MealType.LUNCH, MealType.fromValue("lUNch"));
    }


}