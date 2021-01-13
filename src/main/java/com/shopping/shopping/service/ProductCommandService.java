package com.shopping.shopping.service;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;

public interface ProductCommandService {

    Product createProduct(ProductDTO dto);

}
