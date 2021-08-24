package ch.oldani.streamingserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEvent {
   private Weather weather;
   private Location location;
   private LocalDateTime date;
}
