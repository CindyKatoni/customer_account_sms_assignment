package com.cindy.customer_accounts_sms_assignment.controller;

import com.cindy.customer_accounts_sms_assignment.model.Customer;
import com.cindy.customer_accounts_sms_assignment.payload.CustomerDto;
import com.cindy.customer_accounts_sms_assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
//Dependency Injection of the Customer interface(Loose Coupling)
    private CustomerService customerService;
    //Generate constructor


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Create customer
    //Transform JSON request to XML format ; Send the XML request to an external SOAP service
    //Response will be XML, convert it back to JSON format
    @PostMapping(value = "/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

}
