package net.javaguides.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String jsonTopicName;

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder
                .name("javaguides")
                .build();
    }

    @Bean
    public NewTopic javaguidesTopicJson() {
        return TopicBuilder
                .name(jsonTopicName)
                .build();
    }
}
