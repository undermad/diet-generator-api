package org.ectimel.dietgenerator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fats {
    private BigDecimal totalFats;
    private BigDecimal saturatedFats;


}
