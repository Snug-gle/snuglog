package in.snuglog.api.controller;

import in.snuglog.api.common.error.ErrorResponse;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse InvalidParamExceptionHandler(MethodArgumentNotValidException e) {
    if (e.hasErrors()) {
      ErrorResponse errorResponse = new ErrorResponse(
          "400",
          "잘못된 요청입니다."
      );

      for (FieldError fieldError : e.getFieldErrors()) {
        errorResponse.addValidation(
            fieldError.getField(),
            fieldError.getDefaultMessage()
        );
      }
      return errorResponse;
    }
    return null;
  }
}
