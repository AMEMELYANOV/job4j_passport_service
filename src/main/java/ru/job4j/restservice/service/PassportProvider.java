package ru.job4j.restservice.service;

import ru.job4j.passport.domain.Passport;
import java.util.List;

public interface PassportProvider {
    Passport create(Passport passport);

    void update(int id, Passport passport);

    void delete(int id);

    List<Passport> findAllPassport();

    List<Passport> findBySeries(String seria);

    List<Passport> findUnavailable();

    List<Passport> findReplaceable();
}
