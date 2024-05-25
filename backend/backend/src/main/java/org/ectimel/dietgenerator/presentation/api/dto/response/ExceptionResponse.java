package org.ectimel.dietgenerator.presentation.api.dto.response;

import java.util.Date;

public record ExceptionResponse(String message, Date date, String description) {
}
