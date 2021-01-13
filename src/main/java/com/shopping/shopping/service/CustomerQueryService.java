package com.shopping.shopping.service;

import com.shopping.shopping.domain.Customer;
import java.util.List;

public interface CustomerQueryService {

    List<Customer> findAllByTypeCode(String typeCode);

    List<Customer> getAllCustomer();

}
