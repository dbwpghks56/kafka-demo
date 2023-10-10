package net.javaguides.kafkademo.presentation;

import lombok.RequiredArgsConstructor;
import net.javaguides.kafkademo.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class KafkaRestController {
    private final KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok(message);
    }


}
