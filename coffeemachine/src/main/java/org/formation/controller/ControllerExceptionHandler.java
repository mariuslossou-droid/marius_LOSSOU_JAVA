package org.formation.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

// handle every exception from problemdetails (app.prop) here
@RestControllerAdvice // so that all rest controllers can catch it!
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleValidationException(MethodArgumentNotValidException e) {
        ProblemDetail validationError = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Validation Error"
        );

        // get faulty field and default error message, and map them
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream()
                .collect(
                        Collectors.toMap(
                                FieldError::getField,
                                FieldError::getDefaultMessage
                        )
                );

        validationError.setProperty("errors", errors);

        return validationError;
    }
}
