package com.shopping.shopping.service;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.domain.Product;

import java.util.List;

public interface CategoryQueryService {

    Long count();

    List<Category> getAllProduct();
}
