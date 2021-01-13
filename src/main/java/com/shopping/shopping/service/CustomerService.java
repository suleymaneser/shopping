package com.shopping.shopping.service;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.dto.CustomerDTO;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.repository.CustomerTypeRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerTypeRepository customerTypeRepository;

    private final ShoppingCartService shoppingCartService;

    // given parameters when  create user
    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = prepareCustomer(dto);
        customerRepository.save(customer);
        shoppingCartService.createShoppingCart(customer.getId());
        return customer;
    }

    // find all by type code
    public List<Customer> findAllByTypeCode(String typeCode) {
        return customerRepository.findAllByTypeCode(typeCode);
    }

    // find all user
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
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
