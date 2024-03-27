package org.ectimel.dietgenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1");
        System.out.println(a.divide(BigDecimal.valueOf(100), 3, RoundingMode.FLOOR));


    }
}
