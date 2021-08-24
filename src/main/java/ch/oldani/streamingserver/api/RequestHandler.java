package ch.oldani.streamingserver.api;

import ch.oldani.streamingserver.domain.WeatherEvent;
import ch.oldani.streamingserver.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler {

   private final WeatherService weatherService;

   public RequestHandler(WeatherService weatherService) {
      this.weatherService = weatherService;
   }

   public Mono<ServerResponse> streamWeather(ServerRequest request) {
      return ServerResponse.ok()
                           .contentType(MediaType.APPLICATION_NDJSON)
                           .body(weatherService.streamWeather(), WeatherEvent.class);
   }
}
