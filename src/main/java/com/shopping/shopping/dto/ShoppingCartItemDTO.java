package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@Builder
public class ShoppingCartItemDTO {

    private Long product;

    private Long productCount;

    private Long customer;
}
