package org.ectimel.dietgenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Carbohydrates {

    private BigDecimal totalCarbohydrates;
    private BigDecimal fiber;
    private BigDecimal sugar;

}
