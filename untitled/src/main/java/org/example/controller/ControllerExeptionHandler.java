package org.example.controller;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExeptionHandler {

    ProblemDetail handleValidationException(MethodArgumentNotValidException e )
    {
        ProblemDetail ProblemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Validation Error"
        );
       Map<String,String> errors =  e.getBindingResult().getFieldErrors().steam().collect(
                Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                )
        );
       ProblemDetail.setProperty("errors",errors);
        return ProblemDetail;
    }
}
