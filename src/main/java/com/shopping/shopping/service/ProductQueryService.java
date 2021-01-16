package com.shopping.shopping.service;

import com.shopping.shopping.domain.Product;
import java.util.List;

public interface ProductQueryService {

    Long count();

    List<Product> getAllProduct();

}
