package com.shopping.shopping.dto;

import com.shopping.shopping.domain.Product;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@Builder
public class ShoppingCartItemDTO {

    private Product product;

    private Long productCount;

    private Long customer;
}
