package com.example.managermobilestore.controller;

import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.domain.model.PhoneDTO;
import com.example.managermobilestore.domain.request.phone.CreatePhoneRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneMultiElementRequest;
import com.example.managermobilestore.domain.request.phone.GetListPhoneRequest;
import com.example.managermobilestore.domain.request.phone.UpdatePhoneRequest;
import com.example.managermobilestore.domain.response.BaseItemResponse;
import com.example.managermobilestore.domain.response.BaseListItemResponse;
import com.example.managermobilestore.domain.response.BaseResponse;
import com.example.managermobilestore.exceptions.CustomNotFoundException;
import com.example.managermobilestore.services.PhoneService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/phone")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;
    private final ModelMapper modelMapper = new ModelMapper();
    BaseResponse baseResponse;
    BaseItemResponse<PhoneDTO> baseItemResponse;
    BaseListItemResponse<PhoneDTO> baseListItemResponse;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/list")
    public ResponseEntity<?> getList(@Valid @RequestBody GetListPhoneRequest request){
        log.info("new Query");
        baseListItemResponse = new BaseListItemResponse<>();
        baseListItemResponse.setSuccess(true);

        Page<Phone> page = phoneService.findAll(request);
        List<PhoneDTO> list = page.getContent().stream()
                .map(phone -> modelMapper.map(phone, PhoneDTO.class))
                .collect(Collectors.toList());

        baseListItemResponse.setResult(page.getTotalElements(), list);

        return ResponseEntity.ok().body(baseListItemResponse);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<?> getById(@PathVariable("id") Long id){
        baseItemResponse = new BaseItemResponse<>();
        baseItemResponse.setSuccess(true);

        PhoneDTO phoneDTO = modelMapper.map(phoneService.findById(id), PhoneDTO.class);
        baseItemResponse.setData(phoneDTO);

        return ResponseEntity.ok().body(baseItemResponse);
    }

    @PostMapping("/multielement")
    ResponseEntity<?> findNameByMultiElement(@Valid @RequestBody GetListPhoneMultiElementRequest request){

        Page<Phone> page = phoneService.findNameByMultiElement(request);
        List<PhoneDTO> list = page.getContent().stream().map(phone -> modelMapper.map(phone, PhoneDTO.class)).collect(Collectors.toList());

        baseListItemResponse = new BaseListItemResponse<>();
        baseListItemResponse.setSuccess(!list.isEmpty());
        baseListItemResponse.setResult(page.getTotalElements(), list);

        return ResponseEntity.ok().body(baseListItemResponse);
    }

    @PostMapping("/create")
    ResponseEntity<Phone> createNewPhone(@Valid @RequestBody CreatePhoneRequest request) throws CustomNotFoundException {
        return ResponseEntity.ok().body(phoneService.createNewPhone(request));
    }

    @PutMapping("/update")
    ResponseEntity<?> updatePhone(@RequestBody UpdatePhoneRequest request) {
        baseResponse = new BaseResponse();
        boolean status = phoneService.updateByName(request);
        if(status) {
            return ResponseEntity.noContent().build();
        }
        baseResponse.setSuccess(false);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<BaseResponse> deletePhoneById(@PathVariable("id") Long id){
        phoneService.deletePhoneByName(id);
        baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        return ResponseEntity.ok().body(baseResponse);
    }
}
