package com.mabrar.fraud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public boolean isFraudster(@PathVariable("customerId") Integer customerId) {
        return fraudCheckService.isFraudulentCustomer(customerId);
    }
}
