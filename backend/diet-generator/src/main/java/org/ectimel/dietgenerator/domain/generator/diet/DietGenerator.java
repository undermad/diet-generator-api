package org.ectimel.dietgenerator.domain.generator.diet;

import org.ectimel.dietgenerator.domain.generator.Generator;
import org.ectimel.dietgenerator.domain.model.Diet;

public interface DietGenerator extends Generator {
    Diet generateDiet();
}
