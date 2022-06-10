package com.cindy.customer_accounts_sms_assignment.controller;

import com.cindy.customer_accounts_sms_assignment.payload.CustomerDto;
import com.cindy.customer_accounts_sms_assignment.service.CustomerService;
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

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }


    @GetMapping()
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }



    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id")long id){

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}
