package org.ectimel.dietgenerator.domain.port.in;

import org.ectimel.dietgenerator.domain.model.Diet;

import java.math.BigDecimal;

public interface DietService {

    Diet generateDiet(BigDecimal requiredCalories);

}
