package com.shopping.shopping.service;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.dto.CategoryDTO;
import com.shopping.shopping.dto.CustomerDTO;

public interface CategoryCommandService {

    Category createCategory(CategoryDTO dto);
}
