package com.cindy.customer_accounts_sms_assignment.repository;

import com.cindy.customer_accounts_sms_assignment.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByAccName(String accName);
}
