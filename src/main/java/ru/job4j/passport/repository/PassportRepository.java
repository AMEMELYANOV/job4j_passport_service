package ru.job4j.passport.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.passport.domain.Passport;

import java.util.Calendar;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

    List<Passport> findAllBySeria(int seria);

    List<Passport> findAllByExpiredDateBefore(Calendar date);

    List<Passport> findAllByExpiredDateBetween(Calendar startDate, Calendar endDate);
}
