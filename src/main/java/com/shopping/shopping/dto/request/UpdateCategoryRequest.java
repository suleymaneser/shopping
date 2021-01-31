package com.shopping.shopping.dto.request;


import com.shopping.shopping.dto.CategoryDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class UpdateCategoryRequest {
    private CategoryDTO category;
}
