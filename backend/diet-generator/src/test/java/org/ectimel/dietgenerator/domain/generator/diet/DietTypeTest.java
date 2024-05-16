package org.ectimel.dietgenerator.domain.generator.diet;

import org.ectimel.dietgenerator.domain.exception.WrongInputException;
import org.ectimel.dietgenerator.domain.model.MealType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DietTypeTest {

    @Test
    void fromValue_wrongValues() {
        assertThrows(WrongInputException.class, () -> {

            DietType.fromValue(null);
        }, "Should throw IllegalArgumentException");

        assertThrows(WrongInputException.class, () -> {

            DietType.fromValue("Abc");
        }, "Should throw IllegalArgumentException");
    }

    @Test
    void fromValue_correctValue() {
        assertEquals(DietType.PROTEIN, DietType.fromValue("hIGh pRotEin"));
    }

}