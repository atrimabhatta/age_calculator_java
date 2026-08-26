package com.example.agecalculator.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_age_records")
public class UserAgeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private Integer calculatedAge;

    public UserAgeRecord() {
    }

    public UserAgeRecord(String name, LocalDate dob, Integer calculatedAge) {
        this.name = name;
        this.dob = dob;
        this.calculatedAge = calculatedAge;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getCalculatedAge() {
        return calculatedAge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setCalculatedAge(Integer calculatedAge) {
        this.calculatedAge = calculatedAge;
    }
}