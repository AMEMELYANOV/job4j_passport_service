package ru.job4j.postservice.service;

import org.springframework.stereotype.Service;
import ru.job4j.passport.domain.Passport;

@Service
public class KafkaPostService implements PostService {

    @Override
    public void sendPost(Passport passport) {
        System.out.println("Send to email: Passport - " + passport + " is unavailable");
        System.out.println("=========================================================="
                + "==============================================================================");
    }
}
