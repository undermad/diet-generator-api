package org.ectimel.dietgenerator.application.port.in;

import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.model.Diet;


public interface DietService {
    Diet generateDiet(DietAttributes dietAttributes);
}
