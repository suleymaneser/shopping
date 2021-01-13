package com.shopping.shopping.controller;

import com.shopping.shopping.domain.ShoppingCart;
import com.shopping.shopping.domain.ShoppingCartItem;
import com.shopping.shopping.dto.CalculateDTO;
import com.shopping.shopping.dto.ShoppingCartItemDTO;
import com.shopping.shopping.service.ShoppingCartCommandService;
import com.shopping.shopping.service.ShoppingCartQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/shoppingCart")
@Api(value = "shopping-cart-api")
public class ShoppingCartApiController {

    private final ShoppingCartCommandService shoppingCartCommandService;

    private final ShoppingCartQueryService shoppingCartQueryService;

    @PostMapping(value = "/create/shoppingCart")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createShoppingCart", notes = "Create Shopping Cart")
    public ShoppingCart createShoppingCart(@RequestBody Long user) {
        return shoppingCartCommandService.createShoppingCart(user);
    }

    @PostMapping(value = "/create/shoppingCartItem")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createShoppingCartItem", notes = "Create Shopping Cart Item")
    public ShoppingCartItem createShoppingCartItem(@RequestBody ShoppingCartItemDTO dto) {
        return shoppingCartCommandService.createShoppingCartItem(dto);
    }

    @GetMapping(value = "/calculate")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "calculate", notes = "Calculate total amount")
    public BigDecimal calculate(@RequestBody CalculateDTO dto) {
        return shoppingCartQueryService.calculate(dto);
    }

}
