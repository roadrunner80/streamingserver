package ch.oldani.streamingserver.service;

import ch.oldani.streamingserver.domain.Location;
import ch.oldani.streamingserver.domain.Weather;
import ch.oldani.streamingserver.domain.WeatherEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class WeatherService {

   public Flux<WeatherEvent> streamWeather() {
      Flux<WeatherEvent> events = Flux.fromStream(Stream.generate(this::createEvent));
      return Flux.zip(events, Flux.interval(Duration.ofSeconds(1)), (weatherEvent, seconds) -> weatherEvent);
   }

   private WeatherEvent createEvent() {
      return WeatherEvent.builder()
                         .weather(Weather.builder()
                                         .temprature(getTemprature())
                                         .humidity(getHumidity())
                                         .windSpeed(getWindSpeed())
                                         .build())
                         .location(getLocation())
                         .date(LocalDateTime.now())
                         .build();
   }

   private String getWindSpeed() {
      List<String> windSpeeds = List.of("100 km/h", "101 km/h", "102 km/h", "103 km/h", "104 km/h");
      return windSpeeds.get(new Random().nextInt(windSpeeds.size()));
   }

   private String getHumidity() {
      List<String> humidity = List.of("40%", "41%", "42%", "42%", "44%", "45%", "46%");
      return humidity.get(new Random().nextInt(humidity.size()));
   }

   private String getTemprature() {
      List<String> tempratures =
            List.of("19C", "19.5C", "20C", "20.5C", "21C", "21.5C", "22C", "22.5C", "23C", "23.5C", "24C");
      return tempratures.get(new Random().nextInt(tempratures.size()));
   }

   private Location getLocation() {
      List<Location> locations = List.of(
            Location.builder()
                    .lat(new BigDecimal("47.47073"))
                    .lon(new BigDecimal("7.80228"))
                    .build(),
            Location.builder()
                    .lat(new BigDecimal("47.46183"))
                    .lon(new BigDecimal("7.84820"))
                    .build()
      );
      return locations.get(new Random().nextInt(locations.size()));
   }
}
