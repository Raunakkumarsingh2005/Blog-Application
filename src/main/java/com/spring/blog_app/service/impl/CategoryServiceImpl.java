package com.spring.blog_app.service.impl;

import com.spring.blog_app.dto.CategoryDto;
import com.spring.blog_app.dto.UserDto;
import com.spring.blog_app.entity.Category;
import com.spring.blog_app.entity.Users;
import com.spring.blog_app.mapper.CategoryMapper;
import com.spring.blog_app.repository.CategoryRepository;
import com.spring.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        Optional.ofNullable(categoryDto.getCategoryTitle()).ifPresent(existingCategory::setCategoryTitle);
        Optional.ofNullable(categoryDto.getCategoryDescription()).ifPresent(existingCategory::setCategoryDescription);

        categoryRepository.save(existingCategory);

        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());

    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category c : category) {
            categoryDtos.add(categoryMapper.toDto(c));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
    }
}
