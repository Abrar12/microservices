package com.mohamed.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}" , headers = {"Content-Type=application/json"},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId);

}
