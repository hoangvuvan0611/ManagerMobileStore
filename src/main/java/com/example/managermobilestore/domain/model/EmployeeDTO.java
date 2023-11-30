package com.example.managermobilestore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDTO {
    private String employeeName;
    private String address;
    private Date dateOfBirth;
    private Boolean isSupperAdmin;
}
