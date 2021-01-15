package com.shopping.shopping.dto;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.domain.ProductPrice;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@ApiModel
@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String productCode;

    private Long categoryId;

    private Boolean isActive;

    private String description;

    private String features;

    private Long productPrice;

    public Product fromDto() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, Product.class);
    }

}
