package com.cindy.customer_accounts_sms_assignment.service.impl;

import com.cindy.customer_accounts_sms_assignment.model.Customer;
import com.cindy.customer_accounts_sms_assignment.payload.CustomerDto;
import com.cindy.customer_accounts_sms_assignment.repository.CustomerRepository;
import com.cindy.customer_accounts_sms_assignment.service.CustomerService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    //Use constructor based dependency injection.
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Implement createCustomer method here.
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto){
        //Convert DTO to Entity object
        Customer customer = mapToEntity(customerDto);

        //Save post object to the db using repository method
        Customer newCustomer = customerRepository.save(customer);

        //Convert Entity to DTO to send it back to the controller
        CustomerDto customerResponse = mapToDto(newCustomer);

        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());

    }



    //Create a private method to reuse it. DTO to Entity
    private Customer mapToEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        return customer;
    }

    //Entity to DTO
    private CustomerDto mapToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());

        return customerDto;
    }


}
