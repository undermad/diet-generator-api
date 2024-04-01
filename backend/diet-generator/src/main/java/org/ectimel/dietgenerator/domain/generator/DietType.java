package org.ectimel.dietgenerator.domain.generator;

import lombok.Getter;

@Getter
public enum DietType {
    PROTEIN("Protein"),
    VEGETARIAN("Vegetarian");

    private final String name;

    DietType(String name) {
        this.name = name;
    }

    public static DietType fromValue(String value) {
        for (DietType dietType : DietType.values()){
            if(dietType.getName().equalsIgnoreCase(value))
                return dietType;
        }
        throw new IllegalArgumentException("Unknown diet type");
    }

}
