package org.ectimel.dietgenerator.domain.exception;

public class WrongInputException extends RuntimeException{
    public WrongInputException(String message) {
        super(message);
    }
}
