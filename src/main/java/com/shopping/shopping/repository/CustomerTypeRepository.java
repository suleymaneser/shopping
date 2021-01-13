package com.shopping.shopping.repository;

import com.shopping.shopping.domain.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {

    CustomerType findOneByCode(String code);

}
