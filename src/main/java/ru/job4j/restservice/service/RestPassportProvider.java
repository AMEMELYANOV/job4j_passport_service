package ru.job4j.restservice.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.passport.domain.Passport;

import java.util.List;

@Service
public class RestPassportProvider implements PassportProvider {
    private final String url = "http://localhost:8080/api";
    private final RestTemplate client;

    public RestPassportProvider(RestTemplate client) {
        this.client = client;
    }

    @Override
    public Passport create(Passport passport) {
        return client.postForObject(url + "/save", passport, Passport.class);
    }

    @Override
    public void update(int id, Passport passport) {
        client.put(url + "/update?id=" + id, passport);
    }

    @Override
    public void delete(int id) {
        client.delete(url + "/delete?id=" + id);
    }

    @Override
    public List<Passport> findAllPassport() {
        return client.exchange(
                url + "/findAll",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    @Override
    public List<Passport> findBySeries(String seria) {
        return client.exchange(
                url + "/find?seria=" + seria,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    @Override
    public List<Passport> findUnavailable() {
        return client.exchange(
                url + "/unavailable",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    @Override
    public List<Passport> findReplaceable() {
        return client.exchange(
                url + "/find-replaceable",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }
}
