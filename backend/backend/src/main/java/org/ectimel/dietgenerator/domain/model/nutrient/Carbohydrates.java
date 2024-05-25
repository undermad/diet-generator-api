package org.ectimel.dietgenerator.domain.model.nutrient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carbohydrates {
    private BigDecimal totalCarbohydrates;
    private BigDecimal fiber;
    private BigDecimal sugar;
}
