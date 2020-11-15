package org.grigoreva.model.initiateresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grigoreva.model.initiateresponse.Response;
import org.springframework.beans.factory.annotation.Value;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Создание обертки для ответа на запрос при подключении к серверу
public class InitialResponse {

    @JsonProperty("ServerName")
    private String serverName;
}
