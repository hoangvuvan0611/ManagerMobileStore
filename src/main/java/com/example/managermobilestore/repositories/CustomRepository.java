package com.example.managermobilestore.repositories;

import com.example.managermobilestore.domain.entities.Phone;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepository {
    public static Specification<Phone> buildFilterSpecification() {
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

                predicates.add(criteriaBuilder.like(root.get("nameOfPhone"), "%" + "t" + "%"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
