package com.shopping.shopping.domain;

import com.shopping.shopping.dto.ProductDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

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

    private String images;

    @ManyToOne
    @JoinColumn(name = "productPriceId")
    private ProductPrice productPrice;

    @ManyToOne
    @JoinColumn(name = "sellerId")
    private Customer seller;

    public Product() {
    }

    public ProductDTO toDto() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProductDTO.class);
    }

}
