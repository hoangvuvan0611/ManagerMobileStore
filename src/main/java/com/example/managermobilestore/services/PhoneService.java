package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.model.PhoneDTO;
import com.example.managermobilestore.domain.request.phone.CreatePhoneRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneMultiElementRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneRequest;
import com.example.managermobilestore.domain.request.phone.UpdatePhoneRequest;
import com.example.managermobilestore.exceptions.CustomNotFoundException;
import org.springframework.data.domain.Page;

public interface PhoneService {
    Page<Phone> findAll(GetListPhoneRequest request);
    PhoneDTO findById(Long phoneId);
    Phone createNewPhone(CreatePhoneRequest request) throws CustomNotFoundException;
    Page<Phone> findNameByMultiElement(GetListPhoneMultiElementRequest request);
    Boolean updateByName(UpdatePhoneRequest request);
    void deletePhoneByName(Long id);
}
