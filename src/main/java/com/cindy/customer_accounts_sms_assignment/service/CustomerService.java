package com.cindy.customer_accounts_sms_assignment.service;

import com.cindy.customer_accounts_sms_assignment.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();


}
