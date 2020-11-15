package org.grigoreva.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grigoreva.model.response.Response;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
//Класс-обертка, чтобы передать в модели Json все вложенные объекты
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse {

  @JsonProperty("Response")
  private Response response;
}
