package com.mabrar.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory history = new FraudCheckHistory();
        history.setCustomerId(customerId);
        history.setFraudster(false);
        history.setCreatedAt(LocalDateTime.now());
        fraudCheckHistoryRepository.save(history);
        return false;

    }
}
