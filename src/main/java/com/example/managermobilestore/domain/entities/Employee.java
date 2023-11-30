package com.example.managermobilestore.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", length = 50)
    private String employeeName;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "is_supper_admin")
    private Boolean isSupperAdmin;
}
