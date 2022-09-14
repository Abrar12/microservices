package com.mohamed.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.mohamed.customer",
                "com.mohamed.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.mohamed.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class , args);
    }
}
