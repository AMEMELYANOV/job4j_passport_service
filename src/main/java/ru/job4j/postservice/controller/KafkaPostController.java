package ru.job4j.postservice.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.passport.domain.Passport;
import ru.job4j.postservice.service.KafkaPostService;

@Controller
public class KafkaPostController {
    private final KafkaPostService kafkaPostService;

    public KafkaPostController(KafkaPostService kafkaPostService) {
        this.kafkaPostService = kafkaPostService;
    }

    @KafkaListener(topics = {"unavailable"})
    public void listenPassports(ConsumerRecord<Integer, Passport> input) {
        kafkaPostService.sendPost(input.value());
    }
}
