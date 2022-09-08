package com.mohamed.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customeregistrationRequest){

        customerService.registerCustomer(customeregistrationRequest);
        System.out.println(customeregistrationRequest);

    }
}
