package com.cindy.customer_accounts_sms_assignment.service;

import com.cindy.customer_accounts_sms_assignment.payload.AccountDto;

public interface AccountService {
    AccountDto createAccount(Long customerId, AccountDto accountDto);
}
