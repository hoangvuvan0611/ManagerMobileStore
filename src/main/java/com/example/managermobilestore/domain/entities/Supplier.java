package com.example.managermobilestore.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "suppliers")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Supplier{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_name", length = 50)
    private String supplierName;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private Collection<Phone> phones;
}
