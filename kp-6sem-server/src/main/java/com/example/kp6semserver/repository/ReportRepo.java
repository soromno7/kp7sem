package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<ReportEntity, Long> {
}
