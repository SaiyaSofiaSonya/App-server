package org.grigoreva.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
public class Message {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  public static final String PATTERN = "dd.MM.yyyy HH:mm:ss";

  @JsonProperty("Body") // Для отображения в Json с большой буквы
  private String body;

  @JsonProperty("Timestamp")
  private String timestamp;
}
