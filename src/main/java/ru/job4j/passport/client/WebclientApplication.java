package ru.job4j.passport.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebclientApplication.class, args);
    }

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
