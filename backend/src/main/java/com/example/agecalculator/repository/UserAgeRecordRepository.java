package com.example.agecalculator.repository;

import com.example.agecalculator.entity.UserAgeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgeRecordRepository extends JpaRepository<UserAgeRecord, Long> {
}