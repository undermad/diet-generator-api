package org.ectimel.dietgenerator.application.dto;

import java.util.Date;

public record ExceptionResponse(String message, Date date, String description) {
}
