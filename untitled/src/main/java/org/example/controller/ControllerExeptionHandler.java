package org.example.controller;

public class ControllerExeptionHandler {

    ProblemDetail handleValidationException(MethodArgumentNotValidException e )
    {
        ProblemDetail ProblemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Validation Error"
        );
        return null;
    }
}
