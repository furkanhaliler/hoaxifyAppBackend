package com.hoaxify.ws.controller.handler;

import com.hoaxify.ws.core.results.ErrorResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.SortedMap;
import java.util.TreeMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ErrorResult<Object> handleInvalidJson(
      MethodArgumentNotValidException ex, HttpServletRequest request) {

    final SortedMap<String, String> errorList = new TreeMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(
            objectError -> {
              final String errorField = objectError.getField();
              final String errorMessage = objectError.getDefaultMessage();
              errorList.put(errorField, errorMessage);
            });
    return new ErrorResult<>(
        HttpStatus.BAD_REQUEST, "Validation Error.", request.getRequestURI(), errorList);
  }
}
