package com.shopping.shopping.controller;

import com.shopping.shopping.dto.CustomerTypeDTO;
import com.shopping.shopping.dto.response.CustomerTypeResponse;
import com.shopping.shopping.service.CustomerTypeCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/customer/type")
@Api(value = "customer-type-api")
public class CustomerTypeApiController {

    private final CustomerTypeCommandService customerTypeCommandService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createCustomerType", notes = "Create Customer Type")
    public CustomerTypeResponse createCustomerType(@RequestBody CustomerTypeDTO dto) {
        return new CustomerTypeResponse(customerTypeCommandService.createCustomerType(dto));
    }

}
