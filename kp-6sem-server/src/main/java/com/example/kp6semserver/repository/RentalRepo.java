package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<RentalEntity, Long> {
}
