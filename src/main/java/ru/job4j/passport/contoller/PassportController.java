package ru.job4j.passport.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.passport.domain.Passport;
import ru.job4j.passport.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService trackerService) {
        this.passportService = trackerService;
    }

    @PostMapping("/save")
    public Passport save(@RequestBody Passport passport) {
        return passportService.save(passport);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam int id, @RequestBody Passport passport) {
        boolean status = passportService.update(id, passport);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam int id) {
        boolean status = passportService.delete(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/find")
    public List<Passport> findById(@RequestParam int seria) {
        return passportService.findAllBySeria(seria);
    }

    @GetMapping("/unavailable")
    public List<Passport> findUnavailable() {
        return passportService.findUnavailable();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        return passportService.findReplaceable();
    }

    @GetMapping("/findAll")
    public List<Passport> getAll() {
        return passportService.findAll();
    }
}
