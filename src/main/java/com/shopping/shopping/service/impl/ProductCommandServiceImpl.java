package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.domain.Product;
import com.shopping.shopping.domain.ProductPrice;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.repository.CategoryRepository;
import com.shopping.shopping.repository.ProductPriceRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.service.ProductCommandService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    private final ProductPriceRepository productPriceRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductDTO dto) {
        Product product = prepareProduct(dto);
        productRepository.save(product);
        return product;
    }

    private Category prepareCategory(Long id) {
        if (Objects.nonNull(id)) {
            return categoryRepository.getOne(id);
        }
        return null;
    }

    private Product prepareProduct(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .productCode(dto.getProductCode())
                .categoryId(prepareCategory(dto.getCategoryId()))
                .isActive(true)
                .description(dto.getDescription())
                .features(dto.getFeatures())
                .productPrice(prepareProductPrice(dto.getProductPrice())).build();
    }

    private ProductPrice prepareProductPrice(Long id) {
        if (Objects.nonNull(id)) {
            return productPriceRepository.getOne(id);
        }
        return null;
    }

}
