package com.example.managermobilestore.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", length = 50)
    private String customerName;

    @Column(name = "address", length = 30)
    private String address;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Collection<Bill> bill;
}
