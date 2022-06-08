package com.cindy.customer_accounts_sms_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


