package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String productCode;

    private BigDecimal amount;

}
