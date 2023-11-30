package com.example.managermobilestore.bootstrap;

import com.example.managermobilestore.domain.entities.*;
import com.example.managermobilestore.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final PhoneRepository phoneRepository;
    private final SupplierRepository supplierRepository;
    private final CustomerRepository customerRepository;
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDataSupplier();
        loadMetaData();

    }

    private void loadDataSupplier(){
        Supplier supplier1 = Supplier.builder()
                .supplierName("Supplier1")
                .build();

        Supplier supplier2 = Supplier.builder()
                .supplierName("Supplier2")
                .build();

        Supplier supplier3 = Supplier.builder()
                .supplierName("Supplier3")
                .build();

        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        supplierRepository.save(supplier3);

        Supplier supplier = supplierRepository.findAll().get(0);
        Supplier supplier4 = supplierRepository.findAll().get(1);
//        Supplier supplier5 = supplierRepository.findAll().get(2);

        Phone phone = Phone.builder()
                .phoneName("test")
                .quantity(324)
                .price(new BigDecimal(34234))
                .build();

        Phone phone2 = Phone.builder()
                .phoneName("test00")
                .quantity(4)
                .price(new BigDecimal(34234))
                .build();


        Phone phone3 = Phone.builder()
                .phoneName("test2347800")
                .quantity(54)
                .price(new BigDecimal(32))
                .build();

        phone.setSupplier(supplier);
        phone2.setSupplier(supplier);
        phone3.setSupplier(supplier4);

//        phoneRepository.save(phone);
//        phoneRepository.save(phone2);
//        phoneRepository.save(phone3);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();
        for (int i=1; i< 100000; i++){
            Phone phone4 = Phone.builder()
                    .phoneName("test" + i)
                    .quantity(54)
                    .price(new BigDecimal(32))
                    .build();

//            executorService.submit(() -> System.out.println(phone4.getPhoneName()));
//            int finalI1 = i;
            executorService.submit(phoneRepository.save(phone4));
        }
        long limit = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện" + (limit - start));


        Phone phoneRepo = phoneRepository.findAll().get(0);

        Customer customer1 = Customer.builder()
                .customerName("customer1")
                .address("HP")
                .build();

        customerRepository.save(customer1);

        Customer customerRepo = customerRepository.findAll().get(0);

        Bill bill1 = Bill.builder()
                .customer(customerRepo)
                .build();

        billRepository.save(bill1);

        Bill billRepo = billRepository.findAll().get(0);
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(billRepo);
        billDetail.setPhone(phoneRepo);

        billDetailRepository.save(billDetail);

//        Bill bill = billRepository.findAll().get(0);

//        supplier.getBills().add(bill);
//        billRepo.getSuppliers().add(supplier);
//
//        supplierRepository.save(supplier);
//        billRepository.save(bill);

        log.info("Successful initialization!");
    }

    public Runnable commit(Phone phone){
        return (Runnable) phoneRepository.save(phone);
    }

    private void loadMetaData() {

    }
}
