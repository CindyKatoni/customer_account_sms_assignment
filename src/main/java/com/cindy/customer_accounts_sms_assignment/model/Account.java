package com.cindy.customer_accounts_sms_assignment.model;

import javax.persistence.*;


@Entity
@Table(name = "20952_account")
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String accName;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="customer_id", nullable = false)
        private Customer customer;
    }


