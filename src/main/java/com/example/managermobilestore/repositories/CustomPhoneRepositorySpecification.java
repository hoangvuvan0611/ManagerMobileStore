package com.example.managermobilestore.repositories;

import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.domain.request.phone.GetListPhoneMultiElementRequest;
import com.example.managermobilestore.utils.CustomDate;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomPhoneRepositorySpecification {
    public static Specification<Phone> findNameByMultiElement(GetListPhoneMultiElementRequest request){
        return (root, query, criteriaBuilder) -> {

            List<Predicate>predicates = new ArrayList<>();
            if(StringUtils.hasText(request.getKeywordOfNamePhone())){
                predicates.add(criteriaBuilder.like(root.get("phoneName"), "%" + request.getKeywordOfNamePhone() + "%"));
            }
            try {
                if(StringUtils.hasText(request.getDateFrom())){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createDate"), CustomDate.configFormatAndParseDate().parse(request.getDateFrom())));
                }
                if(StringUtils.hasText(request.getDateTo())){
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createDate"), CustomDate.configFormatAndParseDate().parse(request.getDateTo())));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if(request.getQuantityStart() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"), request.getQuantityStart()));
            }
            if(request.getQuantityLimit() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("quantity"), request.getQuantityLimit()));
            }
            if(request.getPriceStart() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), request.getPriceStart()));
            }
            if(request.getPriceLimit() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), request.getPriceLimit()));
            }
            if(StringUtils.hasText(request.getKeywordOfNameSupplier())){
                Join<Supplier, Phone> phoneSupplierJoin = root.join("supplier");
                predicates.add(criteriaBuilder.like(phoneSupplierJoin.get("supplierName"), "%" + request.getKeywordOfNameSupplier() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
