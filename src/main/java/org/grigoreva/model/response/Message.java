package org.grigoreva.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
public class Message {

  final String PATTERN = "yyyy-MM-dd HH:mm:ss";

  @JsonProperty("Body")  // Для отображения в Json с большой буквы
  private String body;
  @JsonProperty("Timestamp")
  private String timestamp;
}
