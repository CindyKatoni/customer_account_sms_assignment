package com.cindy.customer_accounts_sms_assignment.controller;

import com.cindy.customer_accounts_sms_assignment.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CustomerController {
//create customer rest pi then convert to xml
    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return null;
    }

}
