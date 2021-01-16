package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@Builder
public class ProductDTO {

    private String name;

    private String productCode;

    private Long categoryId;

    private Boolean isActive;

    private String description;

    private String features;

    private Long productPrice;

    private Long sellerId;

}
