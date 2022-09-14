package com.mohamed.customer;

import com.mohamed.amqp.RabbitMQMessageProducer;
import com.mohamed.clients.fraud.FraudClient;
import com.mohamed.clients.fraud.notificaiton.NotificationClient;
import com.mohamed.clients.fraud.notificaiton.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    FraudClient fraudClient;

    @Autowired
    NotificationClient notificationClient;


    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer();
        customer.setFirstname( request.getFirstName());
        customer.setEmail(request.getEmail());
        customer.setLastName(request.getEmail());

        customerRepository.saveAndFlush(customer);
       // FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(), customer.getEmail(), String.format("Hi %s, welcome ...",
                customer.getFirstname()));

        rabbitMQMessageProducer.publish(notificationRequest ,
                "internal.exchange",
                "internal.notification.routing-key");

//
//        notificationClient.sendNotification(
//                new NotificationRequest(
//                        customer.getId(),customer.getEmail(),String.format("Hi %s, welcome ...",
//                        customer.getFirstname())
//                )
//        );



    }
}
