package org.ectimel.dietgenerator.application.port.in;

import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.model.Diet;


public interface CreateDiet {
    Diet createDiet(DietAttributes dietAttributes);
}
