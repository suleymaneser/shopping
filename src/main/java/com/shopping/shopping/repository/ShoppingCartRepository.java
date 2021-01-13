package com.shopping.shopping.repository;

import com.shopping.shopping.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart findOneByCustomerId(Long id);

}
