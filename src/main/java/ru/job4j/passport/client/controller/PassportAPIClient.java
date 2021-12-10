package ru.job4j.passport.client.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.passport.domain.Passport;

import java.util.List;

@RestController
@RequestMapping("/client")
public class PassportAPIClient {
    private final String url = "http://localhost:8080/api";

    private final RestTemplate client;

    public PassportAPIClient(RestTemplate client) {
        this.client = client;
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        return new ResponseEntity<>(
                client.postForObject(url + "/save", passport, Passport.class),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Passport passport) {
        client.put(url + "/update?id=" + id, passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        client.delete(url + "/delete?id=" + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Passport>> findAllPassport() {
        List<Passport> passports = client.exchange(
                url + "/findAll",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();

        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{seria}")
    public ResponseEntity<List<Passport>> findBySeries(@PathVariable String seria) {
        List<Passport> passports = client.exchange(
                url + "/find?seria=" + seria,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/unavailable")
    public ResponseEntity<List<Passport>> findUnavaliabe() {
        List<Passport> passports = client.exchange(
                url + "/unavailable",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find-replaceable")
    public ResponseEntity<List<Passport>> findReplaceable() {
        List<Passport> passports = client.exchange(
                url + "/find-replaceable",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
