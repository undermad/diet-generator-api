package org.ectimel.dietgenerator.application.usecase;

import org.ectimel.dietgenerator.domain.generator.diet.DietAttributes;
import org.ectimel.dietgenerator.domain.model.Diet;


public interface CreateDiet {
    Diet createDiet(DietAttributes dietAttributes);
}
