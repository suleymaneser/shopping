package com.shopping.shopping.dto.response;


import com.shopping.shopping.domain.Category;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class CategoryTypeResponse {
    @NotNull
    @ApiModelProperty(required = true)
    private Category category;

    public CategoryTypeResponse(Category category) {
        super();
        this.category = category;
    }
}
