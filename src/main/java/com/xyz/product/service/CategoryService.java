package com.xyz.product.service;

import com.xyz.product.model.Categories;
import com.xyz.product.repository.CategoryRepository;
import com.xyz.product.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ApiResponse apiResponse;

    public ApiResponse getCategoriesById(Long id) {

        Optional<Categories> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            apiResponse.setCode(HttpURLConnection.HTTP_OK);
            apiResponse.setMessage(category.get());
        } else {
            apiResponse.setCode(HttpURLConnection.HTTP_NO_CONTENT);
            apiResponse.setMessage("No Products available.");
        }
        return apiResponse;
    }

    public ApiResponse saveCategory(Categories categories) {
        Categories category = categoryRepository.save(categories);
        apiResponse.setCode(HttpURLConnection.HTTP_ACCEPTED);
        apiResponse.setMessage(category);
        return apiResponse;
    }
}
