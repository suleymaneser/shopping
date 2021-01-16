package com.shopping.shopping.dto.request;

import com.shopping.shopping.dto.ProductDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class UpdateProductRequest {

    private ProductDTO product;

}
