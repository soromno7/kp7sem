package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<RecordEntity, Long> {
}
