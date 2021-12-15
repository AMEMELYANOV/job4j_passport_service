package ru.job4j.passport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.passport.domain.Passport;

import java.time.LocalDate;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

    List<Passport> findAllBySeria(int seria);

    List<Passport> findAllByExpiredDateBefore(LocalDate date);

    @Query(value = "select * from passports p where :date "
            + "BETWEEN p.expired_Date and p.expired_date + interval  '3 month'", nativeQuery = true)
    List<Passport> findPassportByExpiredDate(LocalDate date);
}
