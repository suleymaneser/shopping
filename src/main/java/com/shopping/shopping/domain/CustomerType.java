package com.shopping.shopping.domain;

import com.shopping.shopping.dto.CustomerTypeDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Entity
@Table(name = "customer_type")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String description;

    public CustomerTypeDTO toDTO() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, CustomerTypeDTO.class);
    }
}
