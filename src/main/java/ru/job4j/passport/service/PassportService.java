package ru.job4j.passport.service;

import org.springframework.stereotype.Service;
import ru.job4j.passport.domain.Passport;
import ru.job4j.passport.repository.PassportRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassportService {
    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public List<Passport> findAll() {
        return StreamSupport.stream(
                passportRepository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    public boolean update(int id, Passport passport) {
        if (findById(id).isPresent()) {
            passport.setId(id);
            passportRepository.save(passport);
            return true;
        }
        return false;
    }

    private Optional<Passport> findById(int id) {
        return passportRepository.findById(id);
    }

    public boolean delete(int id) {
        if (findById(id).isPresent()) {
            passportRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Passport> findAllBySeria(int seria) {
        return passportRepository.findAllBySeria(seria);
    }

    public List<Passport> findUnavailable() {
        LocalDate date = LocalDate.now();
        return passportRepository.findAllByExpiredDateBefore(date);

    }

    public List<Passport> findReplaceable() {
        return passportRepository.findPassportByExpiredDate(LocalDate.now());
    }
}
