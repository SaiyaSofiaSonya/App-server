package org.grigoreva.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
public class Request {

  @JsonProperty("User") // Для отображения в Json с большой буквы
  private User user;
  @JsonProperty("Message")
  private Message message;
}
