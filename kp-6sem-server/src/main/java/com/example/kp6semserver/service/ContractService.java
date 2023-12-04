package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.ContractEntity;
import com.example.kp6semserver.entity.DealerEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.ContractModel;
import com.example.kp6semserver.repository.CarRepo;
import com.example.kp6semserver.repository.ContractRepo;
import com.example.kp6semserver.repository.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private DealerRepo dealerRepo;

    public ContractEntity create (ContractEntity contract, Long dealerID) {
        DealerEntity dealer = dealerRepo.findById(dealerID).get();

        contract.setDealer(dealer);
        return contractRepo.save(contract);
    }

    public ArrayList<ContractModel> getAllContracts() { return ContractModel.toModel(contractRepo.findAll());}

    public void deleteContract(Long id) { contractRepo.deleteById(id);}

}
