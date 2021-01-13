package com.shopping.shopping.service;

import com.shopping.shopping.domain.ShoppingCart;
import com.shopping.shopping.domain.ShoppingCartItem;
import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.dto.ShoppingCartItemDTO;
import com.shopping.shopping.repository.ShoppingCartItemRepository;
import com.shopping.shopping.repository.ShoppingCartRepository;
import com.shopping.shopping.repository.CustomerRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ShoppingCartItemRepository shoppingCartItemRepository;

    private final CustomerRepository customerRepository;

    private ShoppingCart checkAndCreate(Long user) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOneByCustomerId(user);
        if (Objects.isNull(shoppingCart)) {
            return prepareShoppingCart(user);
        }
        return shoppingCart;
    }

    public ShoppingCart createShoppingCart(Long user) {
        if (Objects.isNull(user)) {
            System.out.println("User can to be null");
        }
        ShoppingCart shoppingCart = checkAndCreate(user);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

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
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(dto.getProduct());
        shoppingCartItem.setShoppingCart(checkAndCreate(dto.getCustomer()));
        shoppingCartItem.setProductCount(dto.getProductCount());
        return shoppingCartItem;
    }

}
