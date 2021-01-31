package com.shopping.shopping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shopping.shopping.dto.CategoryDTO;
import com.shopping.shopping.dto.CustomerTypeDTO;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    public CategoryDTO toDTO(String name, String code) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(name);
        dto.setCode(code);
        return dto;
    }
}
