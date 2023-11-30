package com.example.managermobilestore.repositories;

import com.example.managermobilestore.domain.entities.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> , JpaSpecificationExecutor<Phone> {

    @Query("select n from Phone n")
    Collection<Phone> findAllByQuery(Sort sort);

    @Query(value = "select * from phones u where u.phone_name = 'test'", nativeQuery = true)
    Collection<Phone> findByNativeQuery();

    @Query("select n from Phone n where n.phoneName = ?1 ")
    Phone findByIndexParameter(String nameOfPhone);

    @Query("select n from Phone n where n.phoneName = :phoneName ")
    Phone findByNameParameter(@Param("phoneName") String phoneName);

    boolean existsPhoneByPhoneName(String name);

    @Modifying
//    @Query(nativeQuery = true, value = "delete * from phones p where p.phone_name = :phoneName")
    void deletePhoneByPhoneName(String id);

//    Phone updatePhoneByNameOfPhone(Phone phone);


//    @Modifying
//    @Query("update Phone n set n.nameOfPhone = :nameOfphone where n.id = :id")
//    Boolean updateBySetNameOfPhone(@Param("id") Long id, @Param("nameOfPhone") String nameOfPhone);
}
