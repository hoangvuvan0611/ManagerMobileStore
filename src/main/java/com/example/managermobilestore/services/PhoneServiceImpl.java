package com.example.managermobilestore.services;

import com.example.managermobilestore.constant.BaseMessageErr;
import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.domain.model.PhoneDTO;
import com.example.managermobilestore.domain.request.phone.CreatePhoneRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneMultiElementRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneRequest;
import com.example.managermobilestore.domain.request.phone.UpdatePhoneRequest;
import com.example.managermobilestore.exceptions.CustomNotFoundException;
import com.example.managermobilestore.repositories.CustomPhoneRepositorySpecification;
import com.example.managermobilestore.repositories.PhoneRepository;
import com.example.managermobilestore.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<Phone> findAll(GetListPhoneRequest request) {
//        return (List<Phone>) phoneRepository.findAllByQuery(Sort.by(Sort.Direction.DESC,"nameOfPhone"));
        return phoneRepository.findAll(PageRequest.of(request.getPageIndex(), request.getPageSize()));
    }

    @Override
    public PhoneDTO findById(Long phoneId) {
        return modelMapper.map(phoneRepository.findById(phoneId).orElseThrow(() -> new CustomNotFoundException("Phone is not exist!", "phoneId")), PhoneDTO.class);
    }

    @Override
    public Phone createNewPhone(CreatePhoneRequest request) throws CustomNotFoundException {
        Supplier supplier = getSupplier(request.getSupplierId());
        Phone phone;
        if (checkPhoneIsExistByName(request.getName())) {
            phone = phoneRepository.findByNameParameter(request.getName());
            phone.setQuantity(phone.getQuantity() + request.getQuantity());
            return phoneRepository.save(phone);
        } else {
            phone = Phone.builder()
                    .phoneName(request.getName())
                    .quantity(request.getQuantity())
                    .price(request.getPrice())
                    .build();

            phoneRepository.save(phone);
            phone.setSupplier(supplier);
            return phoneRepository.save(phone);
        }
    }

    @Override
    public Page<Phone> findNameByMultiElement(GetListPhoneMultiElementRequest request) {
        Specification<Phone> phoneSpecification = CustomPhoneRepositorySpecification.findNameByMultiElement(request);
        return phoneRepository.findAll(phoneSpecification, PageRequest.of(request.getPageIndex(), request.getPageSize()));
    }

    @Override
    public Boolean updateByName(UpdatePhoneRequest request) {
        checkPhoneIsExistByName(request.getName());
        Phone phone = phoneRepository.findByNameParameter(request.getName());
        if (StringUtils.hasText(request.getName())) {
            phone.setPhoneName(request.getName());
        }
        if (request.getQuantity() != null) {
            phone.setQuantity(request.getQuantity());
        }
        if(request.getPrice() != null){
            phone.setPrice(request.getPrice());
        }
        phoneRepository.save(phone);
        return true;
    }

    @Override
    public void deletePhoneByName(Long id) {
            phoneRepository.deleteById(id);
    }

    boolean checkPhoneIsExistByName(String name) {
        boolean status = phoneRepository.existsPhoneByPhoneName(name);
        if (status)
            return status;
        else
            throw new CustomNotFoundException(name + BaseMessageErr.ERROR_NOT_EXISTS, "name");
    }

    Supplier getSupplier(Long id){
        return supplierRepository.findById(id).orElseThrow(() -> new CustomNotFoundException(
                "Supplier" + BaseMessageErr.ERROR_NOT_EXISTS, "supplierId"));
    }
}
