package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.Product;
import com.shopping.shopping.domain.ShoppingCart;
import com.shopping.shopping.domain.ShoppingCartItem;
import com.shopping.shopping.dto.CalculateDTO;
import com.shopping.shopping.dto.ShoppingCartItemDTO;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.repository.ShoppingCartItemRepository;
import com.shopping.shopping.repository.ShoppingCartRepository;
import com.shopping.shopping.service.ShoppingCartCommandService;
import com.shopping.shopping.service.ShoppingCartQueryService;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ShoppingCartItemRepository shoppingCartItemRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final ShoppingCartQueryService shoppingCartQueryService;

    private ShoppingCart checkAndCreate(Long user) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOneByCustomerId(user);
        if (Objects.isNull(shoppingCart)) {
            return prepareShoppingCart(user);
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart createShoppingCart(Long user) {
        if (Objects.isNull(user)) {
            System.out.println("User cant be null");
        }
        ShoppingCart shoppingCart = checkAndCreate(user);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCartItem createShoppingCartItem(ShoppingCartItemDTO dto) {
        ShoppingCartItem shoppingCartItem = prepareShoppingCartItem(dto);
        shoppingCartItemRepository.save(shoppingCartItem);
        return shoppingCartItem;
    }

    private ShoppingCart prepareShoppingCart(Long userId) {
        Customer customer = customerRepository.findById(userId).get();
        ShoppingCart shoppingCart = new ShoppingCart();
        String cartName = "CART-" + customer.getIdentificationNumber() + customer.getTypeCode().getCode();
        shoppingCart.setCartName(cartName);
        shoppingCart.setCustomerId(customer.getId());
        return shoppingCart;
    }

    private ShoppingCartItem prepareShoppingCartItem(ShoppingCartItemDTO dto) {
        Product product = null;
        if (Objects.nonNull(dto.getProduct())) {
            product = productRepository.findOneById(dto.getProduct());
        }
        CalculateDTO calculateDTO = CalculateDTO.builder()
                .amount(product.getProductPrice().getAmount())
                .count(dto.getProductCount()).build();
        BigDecimal totalAmount = shoppingCartQueryService.calculate(calculateDTO);
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(product);
        shoppingCartItem.setShoppingCart(checkAndCreate(dto.getCustomer()));
        shoppingCartItem.setProductCount(dto.getProductCount());
        shoppingCartItem.setTotalAmount(totalAmount);
        return shoppingCartItem;
    }

}
