package com.shopping.shopping.service;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.dto.request.UpdateProductRequest;

public interface ProductCommandService {

    Product createProduct(ProductDTO dto);

    Product updateProduct(Long productId, UpdateProductRequest request);

}
