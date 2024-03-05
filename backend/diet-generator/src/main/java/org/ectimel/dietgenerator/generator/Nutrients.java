package org.ectimel.dietgenerator.generator;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Nutrients {

    private Calories kcal;
    private Carbohydrates carbohydrates;
    private Proteins proteins;
    private Fats fats;

}
