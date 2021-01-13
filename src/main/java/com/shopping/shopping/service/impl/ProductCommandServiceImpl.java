package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO dto) {
        Product product = prepareProduct(dto);
        productRepository.save(product);
        return product;
    }

    private Product prepareProduct(ProductDTO dto) {
        return Product.builder()
                .amount(dto.getAmount())
                .productCode(dto.getProductCode())
                .name(dto.getName()).build();
    }

}
