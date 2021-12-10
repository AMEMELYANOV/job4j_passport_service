package ru.job4j.passport.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@EqualsAndHashCode
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
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar issueDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar expiredDate;
    private String registrationPlace;
}
