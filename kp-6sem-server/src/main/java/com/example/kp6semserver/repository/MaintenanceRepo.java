package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepo extends JpaRepository<MaintenanceEntity, Long> {
}
