package org.ectimel.dietgenerator.domain.model;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.exception.WrongInputException;

@Getter
public enum DietType {
    
    PROTEIN("High Protein");

    private final String name;

    DietType(String name) {
        this.name = name;
    }

    public static DietType fromValue(String value) {
        for (DietType dietType : DietType.values()){
            if(dietType.getName().equalsIgnoreCase(value))
                return dietType;
        }
        throw new WrongInputException("Unknown diet type");
    }

}
