package org.grigoreva.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.grigoreva.model.request.Request;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
public class RestRequest {

  @JsonProperty("Request")
  private Request request;
}
