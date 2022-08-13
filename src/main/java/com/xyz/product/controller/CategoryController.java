package com.xyz.product.controller;

import com.xyz.product.model.Categories;
import com.xyz.product.response.ApiResponse;
import com.xyz.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable("id") long id) {
        return ResponseEntity.ok(categoryService.getCategoriesById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addProducts(@RequestBody Categories categories) {
        return ResponseEntity.ok(categoryService.saveCategory(categories));
    }
}
