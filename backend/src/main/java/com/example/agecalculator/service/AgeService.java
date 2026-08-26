package com.example.agecalculator.service;

import com.example.agecalculator.dto.AgeRequest;
import com.example.agecalculator.dto.AgeResponse;
import com.example.agecalculator.entity.UserAgeRecord;
import com.example.agecalculator.repository.UserAgeRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {

    private final UserAgeRecordRepository repository;

    public AgeService(UserAgeRecordRepository repository) {
        this.repository = repository;
    }

    public AgeResponse calculateAge(AgeRequest request) {
        LocalDate today = LocalDate.now();

        if (request.getDob().isAfter(today)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }

        int age = Period.between(request.getDob(), today).getYears();

        UserAgeRecord record = new UserAgeRecord(
                request.getName(),
                request.getDob(),
                age
        );

        repository.save(record);

        return new AgeResponse(age);
    }
}