package com.shopping.shopping.dto.response;

import com.shopping.shopping.domain.CustomerType;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class CustomerTypeResponse {

    @NotNull
    @ApiModelProperty(required = true)
    private CustomerType customerType;

    public CustomerTypeResponse(CustomerType customerType) {
        super();
        this.customerType = customerType;
    }
}
