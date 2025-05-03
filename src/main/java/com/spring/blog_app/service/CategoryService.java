package com.spring.blog_app.service;

import com.spring.blog_app.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, Long id);

    public List<CategoryDto> getAllCategory();

    public CategoryDto getCategoryById(Long id);

    public void deleteCategory(Long id);
}
