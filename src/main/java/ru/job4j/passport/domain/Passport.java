package ru.job4j.passport.domain;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int seria;
    private int number;
    private LocalDate issueDate;
    private LocalDate expiredDate;
    private String registrationPlace;
}
