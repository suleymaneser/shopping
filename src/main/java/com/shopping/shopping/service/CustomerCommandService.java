package com.shopping.shopping.service;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.dto.CustomerDTO;
import java.util.List;

public interface CustomerCommandService {

    Customer createCustomer(CustomerDTO dto);

}
