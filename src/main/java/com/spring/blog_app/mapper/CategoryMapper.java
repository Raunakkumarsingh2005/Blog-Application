package com.spring.blog_app.mapper;

import com.spring.blog_app.dto.CategoryDto;
import com.spring.blog_app.entity.Category;
import org.springframework.stereotype.Component;;

@Component
public class CategoryMapper {

    public CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(), category.getCategoryTitle(), category.getCategoryDescription());
    }

    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        return category;
    }
}
