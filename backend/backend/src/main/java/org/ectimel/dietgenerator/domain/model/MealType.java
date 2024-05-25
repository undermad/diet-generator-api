package org.ectimel.dietgenerator.domain.model;

import lombok.Getter;
import org.ectimel.dietgenerator.domain.exception.WrongInputException;

@Getter
public enum MealType {

    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack");

    private final String name;

    MealType(String name) {
        this.name = name;
    }


    public static MealType fromValue(String value) {
        for (MealType mealType : MealType.values()){
            if(mealType.getName().equalsIgnoreCase(value))
                return mealType;
        }
        throw new WrongInputException("Unknown meal type");
    }


}
