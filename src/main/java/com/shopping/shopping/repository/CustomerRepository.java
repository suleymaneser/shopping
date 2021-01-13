package com.shopping.shopping.repository;

import com.shopping.shopping.domain.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByTypeCode(String typeCode);

}
