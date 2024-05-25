package org.ectimel.dietgenerator.domain.model.nutrient;

import lombok.Getter;


@Getter
public enum Filler {
    PROTEIN("Protein"),
    FAT("Fat"),
    CARBOHYDRATE("Carbohydrate"),
    NONE("None");


    private final String name;

    Filler(String name) {
        this.name = name;
    }


    public static Filler fromValue(String value) {
        for (Filler filler : Filler.values()){
            if(filler.getName().equalsIgnoreCase(value))
                return filler;
        }
        throw new IllegalArgumentException("Unknown meal type");
    }


}
