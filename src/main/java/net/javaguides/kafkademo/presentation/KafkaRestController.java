package net.javaguides.kafkademo.presentation;

import lombok.RequiredArgsConstructor;
import net.javaguides.kafkademo.kafka.JsonKafkaProducer;
import net.javaguides.kafkademo.kafka.KafkaProducer;
import net.javaguides.kafkademo.payload.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class KafkaRestController {
    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok(message);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(
            @RequestBody User user
            ) {
        jsonKafkaProducer.sendJson(user);

        return ResponseEntity.ok("json message send to kafka topic");
    }

}
