package com.shopping.shopping.startup;

import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.service.ProductCommandService;
import com.shopping.shopping.service.ProductQueryService;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDemoData {

    private final ProductQueryService productQueryService;

    private final ProductCommandService productCommandService;

    //@EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productQueryService.count();
        if (countOfData.equals(0L)) {
            IntStream.range(0, 20).forEach(item -> productCommandService.createProduct(
                    ProductDTO.builder()
                            .description("Product : " + item)
                            .productCode("code : " + item)
                            .name("name : " + item)
                            .isActive(true)
                            .features("features : " + item)
                            .sellerId(1L)
                            .build()));
        }
    }

}
