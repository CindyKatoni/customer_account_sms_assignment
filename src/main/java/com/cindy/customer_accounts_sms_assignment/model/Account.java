package com.cindy.customer_accounts_sms_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //tO Generate boilerplate code.
@AllArgsConstructor
@NoArgsConstructor
@Entity //to make class an entity
@Table(name = "20952_account")
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String accName;

        //Fetch type LAZY tells hibernate to only fetch related entities from the db
        @ManyToOne(fetch = FetchType.LAZY)
        //JoinColumn annotation to specify foreign key
        @JoinColumn(name="customer_id", nullable = false)
        private Customer customer;
    }


