package com.shopping.shopping.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CalculateDTO {

    private BigDecimal amount;

    private Long count;

}
