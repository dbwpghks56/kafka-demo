package net.javaguides.kafkademo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.kafkademo.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "javaguides", groupId = "myGroup")
//    public void consume(String message) {
//        log.info(String.format("receive Message %s", message));
//    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "myGroup")
    public void consumeJson(User user) {
        log.info(String.format("receive json Message %s", user.toString()));
    }

}
