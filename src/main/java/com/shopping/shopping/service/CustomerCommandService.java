package com.shopping.shopping.service;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.dto.CustomerDTO;

public interface CustomerCommandService {

    Customer createCustomer(CustomerDTO dto);

}
