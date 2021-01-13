package com.shopping.shopping.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.shopping.shopping.domain.Customer;
import com.shopping.shopping.domain.CustomerType;
import com.shopping.shopping.dto.CustomerDTO;
import com.shopping.shopping.service.CustomerQueryService;
import com.shopping.shopping.service.impl.CustomerCommandServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerApiControllerTest {

    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String IDENTIFICATION_NUMBER = "identification_number";
    private static final String TYPE_CODE = "type_code";
    private static final String TYPE_NAME = "type_name";
    private static final String PHONE_NUMBER = "phone_number";


    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Mock
    private CustomerCommandServiceImpl customerCommandServiceImpl;

    @Mock
    private CustomerQueryService customerQueryService;

    private CustomerApiController controller;

    @Before
    public void setup() {
        controller = new CustomerApiController(customerCommandServiceImpl, customerQueryService);
    }

    @Test
    public void givenUserDTOWhenCreateUser() {
        // Arrange
        Customer customer = prepareCustomer();
        CustomerDTO dto = customer.toDTO(customer, true);
        when(customerCommandServiceImpl.createCustomer(dto)).thenReturn(customer);

        // Act
        Customer response = controller.createCustomer(dto);

        // Assert
        softly.assertThat(response.getId()).isEqualTo(ID);
        softly.assertThat(response.getName()).isEqualTo(NAME);
        softly.assertThat(response.getIdentificationNumber()).isEqualTo(IDENTIFICATION_NUMBER);
        softly.assertThat(response.getAddress()).isEqualTo(ADDRESS);
        softly.assertThat(response.getTypeCode().getCode()).isEqualTo(TYPE_CODE);
        softly.assertThat(response.getTypeCode().getDescription()).isEqualTo(TYPE_NAME);
    }

    @Test
    public void givenTypeCodeWhenFindAllByTypeCode() {
        // Arrange
        List<Customer> customerList = new ArrayList<>();
        customerList.add(prepareCustomer());
        when(customerQueryService.findAllByTypeCode(anyString())).thenReturn(customerList);

        // Act
        List<Customer> response = controller.findAllByTypeCode(anyString());

        // Assert
        softly.assertThat(response.get(0).getId()).isEqualTo(ID);
        softly.assertThat(response.get(0).getName()).isEqualTo(NAME);
        softly.assertThat(response.get(0).getIdentificationNumber()).isEqualTo(IDENTIFICATION_NUMBER);
        softly.assertThat(response.get(0).getAddress()).isEqualTo(ADDRESS);
        softly.assertThat(response.get(0).getTypeCode().getCode()).isEqualTo(TYPE_CODE);
        softly.assertThat(response.get(0).getTypeCode().getDescription()).isEqualTo(TYPE_NAME);
    }

    @Test
    public void getAllCustomer() {
        // Arrange
        List<Customer> customerList = new ArrayList<>();
        customerList.add(prepareCustomer());
        when(customerQueryService.getAllCustomer()).thenReturn(customerList);

        // Act
        List<Customer> response = controller.getAllCustomer();

        // Assert
        softly.assertThat(response.get(0).getId()).isEqualTo(ID);
        softly.assertThat(response.get(0).getName()).isEqualTo(NAME);
        softly.assertThat(response.get(0).getIdentificationNumber()).isEqualTo(IDENTIFICATION_NUMBER);
        softly.assertThat(response.get(0).getAddress()).isEqualTo(ADDRESS);
        softly.assertThat(response.get(0).getTypeCode().getCode()).isEqualTo(TYPE_CODE);
        softly.assertThat(response.get(0).getTypeCode().getDescription()).isEqualTo(TYPE_NAME);
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
