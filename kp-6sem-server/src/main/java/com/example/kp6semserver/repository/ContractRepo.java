package com.example.kp6semserver.repository;

import com.example.kp6semserver.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<ContractEntity, Long> {
}
