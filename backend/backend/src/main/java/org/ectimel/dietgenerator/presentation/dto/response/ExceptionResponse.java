package org.ectimel.dietgenerator.presentation.dto.response;

import java.util.Date;

public record ExceptionResponse(String message, Date date, String description) {
}
