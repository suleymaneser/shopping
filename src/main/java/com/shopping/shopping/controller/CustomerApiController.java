package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.dto.CustomerDTO;
import com.shopping.shopping.service.CustomerCommandService;
import com.shopping.shopping.service.CustomerQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/customer")
@Api(value = "customer-api")
public class CustomerApiController {

    private final CustomerCommandService customerCommandService;

    private final CustomerQueryService customerQueryService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createCustomer", notes = "Create Customer")
    public Customer createCustomer(@RequestBody CustomerDTO dto) {
        return customerCommandService.createCustomer(dto);
    }

    @GetMapping(value = "/findAllByTypeCode")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "findAllByTypeCode", notes = "Find All By Type Code")
    public List<Customer> findAllByTypeCode(@RequestBody String typeCode) {
        return customerQueryService.findAllByTypeCode(typeCode);
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getAllCustomer", notes = "Get All Customer")
    public List<Customer> getAllCustomer() {
        return customerQueryService.getAllCustomer();
    }

    @GetMapping(value = "/getAllCustomerByStatus/{status}")
    @ApiOperation(value = "getAllCustomerByStatus", notes = "Get All Customer By Status")
    public List<Customer> getAllCustomerByStatus(@PathVariable boolean status) {
        return customerQueryService.getAllCustomerByStatus(status);
    }

}
