package ch.oldani.streamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
public class StreamingServerApplication {

   public static void main(String[] args) {
      SpringApplication.run(StreamingServerApplication.class, args);
   }

}
