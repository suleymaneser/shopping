package com.shopping.shopping.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.domain.ShoppingCart;
import com.shopping.shopping.repository.CustomerRepository;
import com.shopping.shopping.repository.CustomerTypeRepository;
import com.shopping.shopping.service.impl.CustomerCommandServiceImpl;
import com.shopping.shopping.service.impl.ShoppingCartCommandServiceImpl;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerCommandServiceImplTest {

    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String IDENTIFICATION_NUMBER = "identification_number";
    private static final String TYPE_CODE = "type_code";
    private static final String TYPE_NAME = "type_name";
    private static final String PHONE_NUMBER = "phone_number";

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ShoppingCartCommandServiceImpl shoppingCartCommandServiceImpl;

    @Mock
    private CustomerTypeRepository customerTypeRepository;

    private CustomerCommandServiceImpl service;

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Before
    public void setup() {
        service = new CustomerCommandServiceImpl(customerRepository,customerTypeRepository,shoppingCartCommandServiceImpl);
    }

    @Test
    public void createCustomer() {
        // Arrange
        Customer customer = prepareCustomer();
        ShoppingCart shoppingCart = prepareShoppingCart();
        when(shoppingCartCommandServiceImpl.createShoppingCart(customer.getId())).thenReturn(shoppingCart);
        when(customerTypeRepository.findOneByCode(anyString())).thenReturn(customer.getTypeCode());

        // Act
        Customer customerResponse = service.createCustomer(customer.toDTO(customer, true));

        // Assert
        //softly.assertThat(customerResponse.getId()).isEqualTo(customer.getId());
        softly.assertThat(customerResponse.getAddress()).isEqualTo(customer.getAddress());
        softly.assertThat(customerResponse.getIdentificationNumber()).isEqualTo(customer.getIdentificationNumber());
        softly.assertThat(customerResponse.getName()).isEqualTo(customer.getName());
        softly.assertThat(customerResponse.getPhoneNumber()).isEqualTo(customer.getPhoneNumber());
        softly.assertThat(customerResponse.isStatus()).isEqualTo(customer.isStatus());
        softly.assertThat(customerResponse.getTypeCode().getCode()).isEqualTo(customer.getTypeCode().getCode());
        softly.assertThat(customerResponse.getTypeCode().getDescription()).isEqualTo(customer.getTypeCode().getDescription());
    }

    private ShoppingCart prepareShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1L);
        shoppingCart.setCartName("CART_NAME");
        shoppingCart.setCustomerId(2L);
        return shoppingCart;
    }

    private Customer prepareCustomer() {
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setName(NAME);
        customer.setAddress(ADDRESS);
        customer.setIdentificationNumber(IDENTIFICATION_NUMBER);
        customer.setTypeCode(prepareCustomerType());
        customer.setStatus(true);
        customer.setPhoneNumber(PHONE_NUMBER);
        return customer;
    }

    private CustomerType prepareCustomerType() {
        CustomerType customerType = new CustomerType();
        customerType.setCode(TYPE_CODE);
        customerType.setDescription(TYPE_NAME);
        return customerType;
    }

}
