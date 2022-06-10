package com.cindy.customer_accounts_sms_assignment.controller;

import com.cindy.customer_accounts_sms_assignment.payload.AccountDto;
import com.cindy.customer_accounts_sms_assignment.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<AccountDto> createAccount(@PathVariable(value = "customerId") Long customerId,
                                                   @RequestBody AccountDto accountDto){


        return new ResponseEntity<>(accountService.createAccount(customerId, accountDto), HttpStatus.CREATED);
    }
}
