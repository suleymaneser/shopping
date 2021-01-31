package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Category;
import com.shopping.shopping.service.CategoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements CategoryQueryService {
    @Override
    public Long count() {
        return null;
    }

    @Override
    public List<Category> getAllProduct() {
        return null;
    }
}
