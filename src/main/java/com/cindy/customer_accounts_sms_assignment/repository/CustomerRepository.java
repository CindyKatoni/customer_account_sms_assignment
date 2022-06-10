package com.cindy.customer_accounts_sms_assignment.repository;

import com.cindy.customer_accounts_sms_assignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
