package com.shopping.shopping.repository;

import com.shopping.shopping.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findOneById(Long id);

    @Override
    List<Product> findAll();
}
