package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@Builder
public class CustomerTypeDTO {

    private Long id;

    private String code;

    private String description;

}
