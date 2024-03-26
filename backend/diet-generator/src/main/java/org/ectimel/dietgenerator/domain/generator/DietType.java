package org.ectimel.dietgenerator.domain.generator;

import lombok.Getter;

@Getter
public enum DietType {
    PROTEIN("Protein");

    private final String description;

    DietType(String description) {
        this.description = description;
    }

    public static DietType fromValue(String value) {
        for (DietType dietType : DietType.values()){
            if(dietType.getDescription().equalsIgnoreCase(value))
                return dietType;
        }
        throw new IllegalArgumentException("Unknown diet type");
    }

    public String toValue() {
        return getDescription();
    }


}
