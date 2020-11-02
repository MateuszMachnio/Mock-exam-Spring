package pl.coderslab.simpleTasks;

import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

public class Hero implements Comparable<Hero>, Serializable {

    private String name;
    private Long power;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    public Hero(String name, Long power, LocalDate dateOfBirth, String phoneNumber) {
        this.name = name;
        this.power = power;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Hero hero) {
        return power.compareTo(hero.power);
//        return power > hero.power ? 1 : power < hero.power ? -1 : 0;

    }
}
