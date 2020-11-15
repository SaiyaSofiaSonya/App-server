package org.grigoreva.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grigoreva.model.initiaterequest.InitialRequest;
import org.grigoreva.model.initiateresponse.InitialResponse;
import org.grigoreva.model.RestRequest;
import org.grigoreva.model.RestResponse;
import org.grigoreva.service.UserService;
import org.grigoreva.service.ValidationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j //Использование логов Lombok
@RestController //Для принятия запроса
@RequiredArgsConstructor //Генерация конструктора
public class ServerAppController { //Для принятия Http запросов

//Вызов Bean
  private final UserService userService;
  private final ValidationService validationService; //Обработка исключений, если request payload содержит нул

  final String PREFIX_LOG_ACCEPTED_MESSAGE = "Принято сообщение от клиента ";
  final String COLON = ": ";

//Получение Post запроса при подключения сервера
  @PostMapping
  public InitialResponse connectToServer(@RequestBody InitialRequest request) {
    validationService.validateInitialRequest(request); //Обработка исключений
    log.info("Получен POST request с делатялми: {}", request);
    return userService.handleRequest(request);
  }

//Получение Post запроса  с фамилией и именем пользователя, отправка ответа
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
          "application/vnd.example.todo_payload+json"},
          value = "api")
  public RestResponse userDateReceived(@RequestBody RestRequest request) {
    validationService.validateRequest(request); //Обработка исключений
    log.info("Получен POST request с деталями: {}", request);
    log.info(PREFIX_LOG_ACCEPTED_MESSAGE
            + request.getRequest().getUser().getName()
            + COLON + request.getRequest().getUser().getSecondName()
            + COLON + request.getRequest().getMessage().getBody()
            + COLON + request.getRequest().getMessage().getTimestamp());
    return userService.handleRequestUserData(request);

  }
}

