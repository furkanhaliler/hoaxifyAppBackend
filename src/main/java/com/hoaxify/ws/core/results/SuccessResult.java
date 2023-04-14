package com.hoaxify.ws.core.results;

import org.springframework.http.HttpStatus;

public class SuccessResult<T> extends Result<T> {

  public SuccessResult(final HttpStatus httpStatus, final String message, final T data) {
    super(httpStatus, message, data);
  }

  public SuccessResult(final HttpStatus httpStatus, final String message) {
    super(httpStatus, message, null);
  }
}
