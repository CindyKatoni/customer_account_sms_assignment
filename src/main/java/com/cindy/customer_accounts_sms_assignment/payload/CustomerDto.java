package com.cindy.customer_accounts_sms_assignment.payload;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
