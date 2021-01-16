package com.shopping.shopping.service.impl;

import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    @Override
    public Long count() {
        return productRepository.count();
    }

}
