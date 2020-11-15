package org.grigoreva.model.request;

import static org.grigoreva.model.request.Message.PATTERN;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.grigoreva.model.RestRequest;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class RequestTest {

  @Test
  public void testModelMapping() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "{\n" +
        "  \"Request\": {\n" +
        "    \"User\": {\n" +
        "      \"Name\": \"Иван\",\n" +
        "      \"SecondName\": \"Иванов\"\n" +
        "    },\n" +
        "    \"Message\": {\n" +
        "      \"Body\": \"Привет всем!\",\n" +
        "      \"Timestamp\": \"01.01.2020 12:00:00\"\n" +
        "    }\n" +
        "  }\n" +
        "}";
    final RestRequest request = mapper.readValue(jsonInString, RestRequest.class);
    assertNotNull(request);
    assertNotNull(request.getRequest().getUser());
    assertNotNull(request.getRequest().getMessage());
  }

  @Test
  public void testDateParsing() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern(PATTERN);
    final LocalDateTime dateTime = LocalDateTime.parse("01.01.2020 12:00:00", format);
    assertNotNull(dateTime);
  }
}
