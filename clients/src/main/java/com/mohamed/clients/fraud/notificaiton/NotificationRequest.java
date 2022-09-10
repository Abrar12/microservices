package com.mohamed.clients.fraud.notificaiton;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
