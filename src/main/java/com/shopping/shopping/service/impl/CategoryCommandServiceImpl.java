package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.dto.CategoryDTO;
import com.shopping.shopping.repository.CategoryRepository;
import com.shopping.shopping.service.CategoryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO dto) {
        Category category = prepareCategory(dto);
        categoryRepository.save(category);
        return category;
    }
    private Category prepareCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setCode(dto.getCode());
        return category;
    }
}
