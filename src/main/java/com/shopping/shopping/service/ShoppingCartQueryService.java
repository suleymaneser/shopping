package com.shopping.shopping.service;

import com.shopping.shopping.dto.CalculateDTO;
import java.math.BigDecimal;

public interface ShoppingCartQueryService {

    BigDecimal calculate(CalculateDTO dto);

}
