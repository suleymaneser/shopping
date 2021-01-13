package com.shopping.shopping.domain;

import com.sun.istack.NotNull;
import com.shopping.shopping.dto.CustomerDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String identificationNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "typeId")
    private CustomerType typeCode;

    @NotNull
    private boolean status;

    @NotNull
    private String phoneNumber;

    public CustomerDTO toDTO(Customer customer, boolean status) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setAddress(customer.getAddress());
        dto.setIdentificationNumber(customer.getIdentificationNumber());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setTypeCode(customer.getTypeCode().getCode());
        dto.setStatus(status);
        return dto;
    }

}
