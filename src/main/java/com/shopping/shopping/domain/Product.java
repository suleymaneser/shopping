package com.shopping.shopping.domain;

import com.shopping.shopping.dto.ProductDTO;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Builder
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String productCode;

    private BigDecimal amount;

    public ProductDTO toDto() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProductDTO.class);
    }

}
