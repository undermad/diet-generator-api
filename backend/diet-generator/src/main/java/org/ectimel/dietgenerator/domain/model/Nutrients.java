package org.ectimel.dietgenerator.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Nutrients {

    private Calories kcal;
    private Carbohydrates carbohydrates;
    private Proteins proteins;
    private Fats fats;




}
