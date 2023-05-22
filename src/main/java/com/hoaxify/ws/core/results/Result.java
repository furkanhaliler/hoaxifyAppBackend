package com.hoaxify.ws.core.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

  private HttpStatus httpStatus;
  private String message;
  private long timestamp = new Date().getTime();
  private T data;

  protected Result(final HttpStatus httpStatus, final String message, final T data) {
    this.httpStatus = httpStatus;
    this.message = message;
    this.data = data;
  }
}
