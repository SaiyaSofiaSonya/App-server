package org.grigoreva.service;

import static org.grigoreva.model.request.Message.PATTERN;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grigoreva.model.initiaterequest.InitialRequest;
import org.grigoreva.model.initiateresponse.InitialResponse;
import org.grigoreva.model.RestResponse;
import org.grigoreva.model.response.Message;
import org.grigoreva.model.RestRequest;
import org.grigoreva.model.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j  //Подключает логирование
@Service //Класс для создания Bean, маркирует служебный класс
@RequiredArgsConstructor //Позволяет создать конструктор неявно
public class UserService {

  private static final String RESPONSE_MESSAGE_PREFIX = "Добрый день, ";
  private static final String RESPONSE_MESSAGE_POSTFIX
      = ", Ваше сообщение успешно обработано!";

  @Value("${server.serverName}")
  private String serverName;

//Создание Response
  public RestResponse handleRequestUserData(RestRequest restRequest){

    DateTimeFormatter format = DateTimeFormatter.ofPattern(PATTERN);
    final Message responseMessage = Message.builder().body(RESPONSE_MESSAGE_PREFIX
            .concat(restRequest.getRequest().getUser().getName())
            .concat(RESPONSE_MESSAGE_POSTFIX))
            .timestamp(LocalDateTime.now().format(format))
            .build();
    log.debug("Response сообщение сгенерировано с деталями: {}", responseMessage);
    final Response response = Response.builder()
            .message(responseMessage)
            .build();
    return new RestResponse(response);
 }

//Создание Response с именем сервера
  public InitialResponse handleRequest(InitialRequest initialRequest) {

    log.info("Клиент {} зарегистрировался/подключился ", initialRequest.getAdmin().getLogin());
    final InitialResponse initialResponse = new InitialResponse(serverName);
    log.debug("Response сообщение сгенерировано с деталями : {}", initialResponse );
    return initialResponse;
  }


}
