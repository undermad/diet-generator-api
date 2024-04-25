package org.ectimel.dietgenerator.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MealTypeTest {

    @Test
    void fromValue_wrongValues() {
        assertThrows(IllegalArgumentException.class, () -> {

            MealType.fromValue(null);
        }, "Should throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class, () -> {

            MealType.fromValue("Abc");
        }, "Should throw IllegalArgumentException");
    }

    @Test
    void fromValue_correctValue() {
        assertEquals(MealType.LUNCH, MealType.fromValue("lUNch"));
    }


}