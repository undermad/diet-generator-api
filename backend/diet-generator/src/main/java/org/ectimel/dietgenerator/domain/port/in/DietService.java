package org.ectimel.dietgenerator.domain.port.in;

import io.vavr.control.Try;
import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.model.Diet;
import org.ectimel.dietgenerator.domain.generator.DietType;

import java.math.BigDecimal;

public interface DietService {
    Try<Diet> generateDiet(DietAttributes dietAttributes);
}
