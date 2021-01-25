package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.dto.request.UpdateProductRequest;
import com.shopping.shopping.service.ProductCommandService;
import com.shopping.shopping.service.ProductQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product")
@Api(value = "product-api")
public class ProductApiController {

    private final ProductCommandService productCommandService;

    private final ProductQueryService productQueryService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createProduct", notes = "Create Product")
    public Product createProduct(@RequestBody ProductDTO dto) throws Exception {
        return productCommandService.createProduct(dto);
    }

    @CrossOrigin
    @GetMapping(value = "/getAllProduct")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getAllProduct", notes = "Get All Product")
    public List<Product> getAllProduct() {
        return productQueryService.getAllProduct();
    }

    @PutMapping(value = "/updateProduct/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "updateProduct", notes = "Update Product")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody UpdateProductRequest request)
            throws Exception {
        return productCommandService.updateProduct(productId, request);
    }

}
