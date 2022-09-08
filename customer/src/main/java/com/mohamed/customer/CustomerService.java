package com.mohamed.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer();
        customer.setFirstname( request.getFirstName());
        customer.setEmail(request.getEmail());
        customer.setLastName(request.getEmail());

        customerRepository.saveAndFlush(customer);

       boolean isFraud = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}" , Boolean.class , customer.getId()
        );

        System.out.println("Hiiii " +isFraud);

    }
}
