package org.example.controller;

@RestControllerAdvice
public class ControllerExeptionHandler {

    ProblemDetail handleValidationException(MethodArgumentNotValidException e )
    {
        ProblemDetail ProblemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Validation Error"
        );
        return ProblemDetail;
    }
}
