package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.dto.CustomerDTO;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.repository.CustomerTypeRepository;
import com.shopping.shopping.service.CustomerCommandService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CustomerRepository customerRepository;

    private final CustomerTypeRepository customerTypeRepository;

    private final ShoppingCartCommandServiceImpl shoppingCartCommandServiceImpl;

    // given parameters when  create user
    @Override
    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = prepareCustomer(dto);
        customerRepository.save(customer);
        shoppingCartCommandServiceImpl.createShoppingCart(customer.getId());
        return customer;
    }

    private Customer prepareCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setIdentificationNumber(dto.getIdentificationNumber());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setTypeCode(prepareCustomerType(dto.getTypeCode()));
        customer.setStatus(true);
        return customer;
    }

    private CustomerType prepareCustomerType(String typeCode) {
        CustomerType customerType = customerTypeRepository.findOneByCode(typeCode);
        if (Objects.isNull(customerType)) {
            System.out.println("Customer type is null");
        }
        return customerType;
    }
}
