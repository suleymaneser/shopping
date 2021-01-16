package com.shopping.shopping.dto;

import com.shopping.shopping.domain.ProductPrice;
import com.shopping.shopping.enums.CurrencyType;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@ApiModel
@Getter
@Setter
@Builder
public class ProductPriceDTO {

    private BigDecimal amount;

    private CurrencyType currency;

    public ProductPrice fromDto() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProductPrice.class);
    }

}
