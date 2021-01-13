package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.service.CustomerQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerRepository customerRepository;

    // find all by type code
    @Override
    public List<Customer> findAllByTypeCode(String typeCode) {
        return customerRepository.findAllByTypeCode(typeCode);
    }

    // find all user
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

}
