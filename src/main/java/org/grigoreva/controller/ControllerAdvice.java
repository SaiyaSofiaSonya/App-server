package org.grigoreva.controller;

import lombok.extern.slf4j.Slf4j;
import org.grigoreva.exeption.RequestInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j //Подключено логирование
@RestControllerAdvice //Используетсся для глобальной обработке ошибок на уровне приложения
public class ControllerAdvice {

  @ExceptionHandler(RequestInvalidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) //Устанавливает 400 статус ответа, вместо 500
  public void handleBadRequest(RequestInvalidException e) {
    log.error("Request payload не валидно. {}", e.getMessage());
  }
}
