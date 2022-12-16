package com.example.shop.category.controller;

import com.example.shop.category.model.Category;
import com.example.shop.category.service.CategoryService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{slug}/products")
    public Category getCategoriesWithProducts(
            @PathVariable
            @Pattern(regexp = "[a-z0-9\\-]+")
            @Length(max = 255)
            String slug) {
        return categoryService.getCategoriesWithProducts(slug);
    }

}