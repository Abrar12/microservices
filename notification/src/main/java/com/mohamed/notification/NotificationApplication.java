package com.mohamed.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.mohamed.notification",
                "com.mohamed.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String args[]){
        SpringApplication.run(NotificationApplication.class , args);
    }
}
