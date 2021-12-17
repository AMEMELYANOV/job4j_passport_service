package ru.job4j.restservice.service;

import org.springframework.stereotype.Service;
import ru.job4j.passport.domain.Passport;

import java.util.List;

@Service
public class KafkaPassportProvider  implements PassportProvider {
    private final RestPassportProvider provider;

    public KafkaPassportProvider(RestPassportProvider provider) {
        this.provider = provider;
    }

    @Override
    public Passport create(Passport passport) {
        return null;
    }

    @Override
    public void update(int id, Passport passport) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Passport> findAllPassport() {
        return null;
    }

    @Override
    public List<Passport> findBySeries(String seria) {
        return null;
    }

    @Override
    public List<Passport> findUnavailable() {
        return provider.findUnavailable();
    }

    @Override
    public List<Passport> findReplaceable() {
        return null;
    }
}
