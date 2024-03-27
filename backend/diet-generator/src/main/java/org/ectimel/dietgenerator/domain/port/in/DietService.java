package org.ectimel.dietgenerator.domain.port.in;

import org.ectimel.dietgenerator.domain.generator.DietAttributes;
import org.ectimel.dietgenerator.domain.model.Diet;


public interface DietService {
    Diet generateDiet(DietAttributes dietAttributes);
}
