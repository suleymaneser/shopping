package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.dto.CategoryDTO;
import com.shopping.shopping.dto.response.CategoryTypeResponse;
import com.shopping.shopping.service.CategoryCommandService;
import com.shopping.shopping.service.CategoryQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/category")
@Api(value = "category-api")
public class CategoryApiController {
    private final CategoryCommandService categoryCommandService;

    private final CategoryQueryService categoryQueryService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "createCategory", notes = "Create Category")
    public CategoryTypeResponse createCustomerType(@RequestBody CategoryDTO dto) {
        return new CategoryTypeResponse(categoryCommandService.createCategory(dto));
    }

    @CrossOrigin
    @GetMapping(value = "/getAllCategory")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getAllCategory", notes = "Get All Category")
    public List<Category> getAllCategory() { return categoryQueryService.getAllProduct(); }
}
