package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.ServiceStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceStationRepo extends JpaRepository<ServiceStationEntity, Long> {
}
