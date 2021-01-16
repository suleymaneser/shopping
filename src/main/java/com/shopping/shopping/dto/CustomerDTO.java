package com.shopping.shopping.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class CustomerDTO {

    private String name;

    private String address;

    private String identificationNumber;

    private String typeCode;

    private boolean status;

    private String phoneNumber;

}
