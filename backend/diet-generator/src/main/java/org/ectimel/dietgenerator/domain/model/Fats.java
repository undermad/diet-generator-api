package org.ectimel.dietgenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Fats {
    private BigDecimal totalFats;
    private BigDecimal saturatedFats;


}
