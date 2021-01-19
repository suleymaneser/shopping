package com.shopping.shopping.service;

import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.dto.CustomerTypeDTO;

public interface CustomerTypeCommandService {

    CustomerType createCustomerType(CustomerTypeDTO dto);

}
