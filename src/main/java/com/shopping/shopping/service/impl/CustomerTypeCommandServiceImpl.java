package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.dto.CustomerTypeDTO;
import com.shopping.shopping.repository.CustomerTypeRepository;
import com.shopping.shopping.service.CustomerTypeCommandService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerTypeCommandServiceImpl implements CustomerTypeCommandService {

    private final CustomerTypeRepository customerTypeRepository;

    public CustomerType createCustomerType(CustomerTypeDTO dto) {
        CustomerType customerType = checkAndPrepareCustomerType(dto);
        customerTypeRepository.save(customerType);
        return customerType;
    }

    private CustomerType checkAndPrepareCustomerType(CustomerTypeDTO dto) {
        if (Objects.isNull(checkCustomerType(dto.getCode()))) {
            System.out.println("This type of customer already exists");
            // Bu kısımda farklı bir exception kullanılmalı!
        }
        CustomerType customerType = new CustomerType();
        customerType.setCode(dto.getCode());
        customerType.setDescription(dto.getDescription());
        return customerType;
    }

    private CustomerType checkCustomerType(String code) {
        return customerTypeRepository.findOneByCode(code);
    }

}
