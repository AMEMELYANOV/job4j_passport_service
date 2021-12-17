package ru.job4j.restservice.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.job4j.passport.domain.Passport;
import ru.job4j.restservice.service.KafkaPassportProvider;

import java.util.List;

@EnableScheduling
@Component
public class KafkaPassportController {
    private final KafkaTemplate<Integer, Passport> template;
    private final KafkaPassportProvider passportProvider;

    public KafkaPassportController(KafkaTemplate<Integer, Passport> template, KafkaPassportProvider passportProvider) {
        this.template = template;
        this.passportProvider = passportProvider;
    }

    @Scheduled(initialDelay = 15000, fixedDelay = 100000)
    public void passportsToPost() {
        List<Passport> passports = passportProvider.findUnavailable();
        for (Passport passport : passports) {
            template.send("unavailable", passport);
        }
    }
}