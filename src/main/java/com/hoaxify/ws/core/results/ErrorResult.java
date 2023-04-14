package com.hoaxify.ws.core.results;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResult<T> extends Result<T> {

  private String path;

  public ErrorResult(
      final HttpStatus httpStatus, final String message, final String path, final T data) {
    super(httpStatus, message, data);
    this.path = path;
  }

  public ErrorResult(final HttpStatus httpStatus, final String message, final String path) {
    super(httpStatus, message, null);
    this.path = path;
  }
}
