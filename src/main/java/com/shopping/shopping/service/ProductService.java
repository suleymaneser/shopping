package com.shopping.shopping.service;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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
