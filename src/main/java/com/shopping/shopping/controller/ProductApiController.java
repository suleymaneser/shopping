package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.service.ProductCommandService;
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
@RequestMapping(value = "/api//product")
@Api(value = "product-api")
public class ProductApiController {

    private final ProductCommandService productCommandService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createProduct", notes = "Create Product")
    public Product createProduct(@RequestBody ProductDTO dto) {
        return productCommandService.createProduct(dto);
    }

}
