package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.ContractEntity;
import com.example.kp6semserver.entity.ContractPriceEntity;
import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.model.ContractModel;
import com.example.kp6semserver.repository.ContractRepo;
import com.example.kp6semserver.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractService {
    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private OrderRepo orderRepo;

    public ContractEntity create (ContractEntity contract) {
        return contractRepo.save(contract);
    }

    public Integer calculateContractPrice (ContractPriceEntity entity) {
        return entity.getQuantity() * 20;
    }

    public ArrayList<ContractModel> getAllContracts() { return ContractModel.toModel(contractRepo.findAll());}

    public void deleteContract(Long id) { contractRepo.deleteById(id);}

}
