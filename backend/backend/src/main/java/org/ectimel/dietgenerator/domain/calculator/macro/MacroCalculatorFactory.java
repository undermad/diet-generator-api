package org.ectimel.dietgenerator.domain.calculator.macro;

import org.ectimel.dietgenerator.domain.exception.WrongInputException;
import org.ectimel.dietgenerator.domain.model.DietType;

public class MacroCalculatorFactory {
    public static MacroCalculator getMacroCalculator(DietType dietType) {
        return switch (dietType) {
            case PROTEIN -> new HighProteinMacroCalculator();
            default -> throw new WrongInputException("Unknown diet type");
        };
    }
}
