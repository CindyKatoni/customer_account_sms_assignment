package com.cindy.customer_accounts_sms_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "20952_customer", uniqueConstraints = {@UniqueConstraint(columnNames = "phoneNumber")})
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "firstName", nullable = false)
        private String firstName;
        @Column(name = "lastName", nullable = false)
        private String lastName;
        @Column(name = "phoneNumber", nullable = false)
        private String phoneNumber;

        //Cascade type all to save the parent along with the child,
        //Orphan removal to remove child when parent is removed
        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
        //Use Set since it doesn't allow duplicates
        private Set<Account> accounts = new HashSet<>();



    public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


