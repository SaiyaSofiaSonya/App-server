package org.grigoreva.controller;

import lombok.extern.slf4j.Slf4j;
import org.grigoreva.exeption.RequestInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(RequestInvalidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public void handleBadRequest(RequestInvalidException e) {
    log.error("Request payload is not valid. {}", e.getMessage());
  }
}
