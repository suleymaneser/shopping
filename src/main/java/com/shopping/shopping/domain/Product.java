package com.shopping.shopping.domain;

import com.shopping.shopping.dto.ProductDTO;
import com.sun.istack.NotNull;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    private Boolean isActive;

    private String description;

    private String features;

    @ManyToOne
    private ProductPrice productPrice;

    public ProductDTO toDto() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProductDTO.class);
    }

}
