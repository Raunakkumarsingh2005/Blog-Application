package com.spring.blog_app.dto;

public class CategoryDto {
    private Long id;
    private String categoryTitle;
    private String categoryDescription;

    public CategoryDto(Long id, String categoryId, String categoryDescription) {
        this.id = id;
        this.categoryTitle = categoryId;
        this.categoryDescription = categoryDescription;
    }

    public Long getId() {
        return id;
    }

    public CategoryDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public CategoryDto setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
        return this;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public CategoryDto setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        return this;
    }
}
