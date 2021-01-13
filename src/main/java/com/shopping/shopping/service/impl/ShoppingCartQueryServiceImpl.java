package com.shopping.shopping.service.impl;

import com.shopping.shopping.dto.CalculateDTO;
import com.shopping.shopping.service.ShoppingCartQueryService;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService{

    private static final BigDecimal ZERO = BigDecimal.ZERO;

    @Override
    public BigDecimal calculate(CalculateDTO dto) {
        if (Objects.isNull(dto.getAmount()) || Objects.isNull(dto.getCount())) {
            System.out.println("Amount or count cant be null");
        }
        if (dto.getAmount().equals(0) || dto.getCount().equals(0)) {
            return ZERO;
        }
        return dto.getAmount().multiply(BigDecimal.valueOf(dto.getCount()));
    }

}
