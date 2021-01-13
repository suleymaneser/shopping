package com.shopping.shopping.repository;

import com.shopping.shopping.domain.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {

}
