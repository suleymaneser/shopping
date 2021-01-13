package com.shopping.shopping.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.service.ProductService;
import java.math.BigDecimal;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductApiControllerTest {

    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final String PRODUCT_CODE = "product_code";
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(1000);

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Mock
    private ProductService productService;

    private ProductApiController controller;

    @Before
    public void setup() {
        controller = new ProductApiController(productService);
    }

    @Test
    public void givenProductDTOWhenCreateProduct() {
        // Arrange
        ProductDTO dto = prepareProduct().toDto();
        when(productService.createProduct(any())).thenReturn(prepareProduct());

        // Act
        Product response = controller.createProduct(dto);

        // Assert
        softly.assertThat(response.getId()).isEqualTo(ID);
        softly.assertThat(response.getName()).isEqualTo(NAME);
        softly.assertThat(response.getProductCode()).isEqualTo(PRODUCT_CODE);
        softly.assertThat(response.getAmount()).isEqualTo(AMOUNT);
    }

    private Product prepareProduct() {
        return Product.builder()
                .id(ID)
                .amount(AMOUNT)
                .name(NAME)
                .productCode(PRODUCT_CODE).build();
    }

}
