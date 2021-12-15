package ru.job4j.passport.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.passport.client.service.PassportProvider;
import ru.job4j.passport.domain.Passport;

import java.util.List;

@RestController
@RequestMapping("/client")
public class PassportAPIClient {
    private final PassportProvider passportProvider;

    public PassportAPIClient(PassportProvider passportProvider) {
        this.passportProvider = passportProvider;
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        return new ResponseEntity<>(
                passportProvider.create(passport),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Passport passport) {
        passportProvider.update(id, passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        passportProvider.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Passport>> findAllPassport() {
        List<Passport> passports = passportProvider.findAllPassport();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{seria}")
    public ResponseEntity<List<Passport>> findBySeries(@PathVariable String seria) {
        List<Passport> passports = passportProvider.findBySeries(seria);
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/unavailable")
    public ResponseEntity<List<Passport>> findUnavaliabe() {
        List<Passport> passports = passportProvider.findUnavaliabe();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find-replaceable")
    public ResponseEntity<List<Passport>> findReplaceable() {
        List<Passport> passports = passportProvider.findReplaceable();
        return new ResponseEntity<>(passports,
                passports != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
