package com.shopping.shopping.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.domain.ProductPrice;
import com.shopping.shopping.dto.ProductDTO;
import com.shopping.shopping.service.ProductQueryService;
import com.shopping.shopping.service.impl.ProductCommandServiceImpl;
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
    private ProductCommandServiceImpl productCommandServiceImpl;

    @Mock
    private ProductQueryService productQueryService;

    private ProductApiController controller;

    @Test
    public void givenProductDTOWhenCreateProduct() {
        // Arrange
        ProductDTO dto = prepareProduct().toDto();
        when(productCommandServiceImpl.createProduct(any())).thenReturn(prepareProduct());

        // Act
        Product response = controller.createProduct(dto);

        // Assert
        softly.assertThat(response.getId()).isEqualTo(ID);
        softly.assertThat(response.getName()).isEqualTo(NAME);
        softly.assertThat(response.getProductCode()).isEqualTo(PRODUCT_CODE);
        softly.assertThat(response.getProductPrice().getAmount()).isEqualTo(AMOUNT);
    }

    private Product prepareProduct() {
        Product product = new Product();
        ProductPrice productPrice = new ProductPrice();
        productPrice.setAmount(AMOUNT);
        product.setId(ID);
        product.setProductPrice(productPrice);
        product.setName(NAME);
        product.setProductCode(PRODUCT_CODE);
        return product;
    }

    @Before
    public void setup() {
        controller = new ProductApiController(productCommandServiceImpl, productQueryService);
    }

}
