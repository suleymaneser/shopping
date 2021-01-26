package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.Product;
import com.shopping.shopping.domain.ProductPrice;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.dto.request.UpdateProductRequest;
import com.shopping.shopping.repository.CategoryRepository;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.repository.ProductPriceRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.service.ProductCommandService;
import java.util.Objects;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private static final String SELLER_TYPE = "SELLER";
    private static final String RECEIVER_TYPE = "RECEIVER";
    private static final String SELLER_AND_RECEIVER = "SELLER_AND_RECEIVER";

    private final ProductRepository productRepository;

    private final ProductPriceRepository productPriceRepository;

    private final CategoryRepository categoryRepository;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Product createProduct(ProductDTO dto) throws Exception {
        Product product = prepareProduct(dto);
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public Product updateProduct(Long productId, UpdateProductRequest request) throws Exception {
        Product product = productRepository.findOneById(productId);
        if (!product.getIsActive().equals(true)) {
            System.out.println("The product you want to update is not active");
        }
        product.setProductCode(request.getProduct().getProductCode());
        product.setName(request.getProduct().getName());
        product.setDescription(request.getProduct().getDescription());
        product.setFeatures(request.getProduct().getFeatures());
        if (Objects.nonNull(request.getProduct().getProductPrice())) {
            ProductPrice productPrice = new ProductPrice();
            productPrice.setAmount(request.getProduct().getProductPrice().getAmount());
            productPrice.setCurrency(request.getProduct().getProductPrice().getCurrency());
            product.setProductPrice(productPrice);
            prepareProductPrice(product.getProductPrice());
        }
        if (Objects.nonNull(request.getProduct().getCategoryId())) {
            product.setCategoryId(prepareCategory(request.getProduct().getCategoryId()));
        }
        if (Objects.nonNull(request.getProduct().getSellerId())) {
            product.setSeller(checkAndPrepareSeller(request.getProduct().getSellerId()));
        }
        productRepository.save(product);
        return product;
    }

    private Customer checkAndPrepareSeller(Long id) throws Exception {
        Customer customer;
        if (Objects.nonNull(id)) {
            customer = customerRepository.findById(id).get();
            if (customer.getTypeCode().getCode().equals(RECEIVER_TYPE)) {
                throw new Exception("This customer cannot sell products");
            } else {
                return customer;
            }
        }
        return null;
    }

    private Category prepareCategory(Long id) {
        Category category = null;
        if (Objects.nonNull(id)) {
            category = categoryRepository.findOneById(id);
        }
        return category;
    }

    private Product prepareProduct(ProductDTO dto) throws Exception {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setProductCode(dto.getProductCode());
        product.setCategoryId(prepareCategory(dto.getCategoryId()));
        product.setFeatures(dto.getFeatures());
        product.setImages(dto.getImages());
        product.setProductPrice(prepareProductPrice(dto.getProductPrice().fromDto()));
        product.setSeller(checkAndPrepareSeller(dto.getSellerId()));
        product.setIsActive(true);
        return product;
    }

    private ProductPrice prepareProductPrice(ProductPrice productPrice) {
        if (Objects.nonNull(productPrice)) {
            return productPriceRepository.save(productPrice);
        }
        return null;
    }

}
