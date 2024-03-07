package org.ectimel.dietgenerator.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carbohydrates {

    private Double totalCarbohydrates;
    private Double fiber;
    private Double sugar;
}
