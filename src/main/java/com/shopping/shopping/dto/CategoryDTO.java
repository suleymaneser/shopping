package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class CategoryDTO {

    private String name;

    private String code;

}
