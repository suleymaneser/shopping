package com.shopping.shopping.service;

import com.shopping.shopping.domain.ShoppingCart;
import com.shopping.shopping.domain.ShoppingCartItem;
import com.shopping.shopping.dto.ShoppingCartItemDTO;

public interface ShoppingCartCommandService {

    ShoppingCart createShoppingCart(Long user);

    ShoppingCartItem createShoppingCartItem(ShoppingCartItemDTO dto);

}
