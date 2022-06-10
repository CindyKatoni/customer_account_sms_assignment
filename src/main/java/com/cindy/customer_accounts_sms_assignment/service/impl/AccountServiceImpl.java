package com.cindy.customer_accounts_sms_assignment.service.impl;

import com.cindy.customer_accounts_sms_assignment.exception.ResourceNotFoundException;
import com.cindy.customer_accounts_sms_assignment.model.Account;
import com.cindy.customer_accounts_sms_assignment.model.Customer;
import com.cindy.customer_accounts_sms_assignment.payload.AccountDto;
import com.cindy.customer_accounts_sms_assignment.repository.AccountRepository;
import com.cindy.customer_accounts_sms_assignment.repository.CustomerRepository;
import com.cindy.customer_accounts_sms_assignment.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AccountDto createAccount(Long customerId, AccountDto accountDto) {
        Account account = mapToEntity(accountDto);

        //retrieve Customer entity by id
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(()-> new ResourceNotFoundException("Customer", "id", customerId));
        //set customer to the account entity
        account.setCustomer(customer);

        //save account entity to the database
        Account newAccount = accountRepository.save(account);

        return mapToDto(newAccount);
    }

    //create private methods
    private Account mapToEntity(AccountDto accountDto){
        Account account = new Account();
        account.setAccName(accountDto.getAccName());
        return account;
    }

    private AccountDto mapToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccName(account.getAccName());
        return accountDto;
    }
}
