package org.grigoreva.model.initiaterequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Класс-обертка, чтобы передать в модели Json все вложенные объекты
public class InitialRequest {
    @JsonProperty("Admin")
    private Admin admin;
}
