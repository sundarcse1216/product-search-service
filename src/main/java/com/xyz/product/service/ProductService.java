package com.xyz.product.service;

import com.xyz.product.dto.Search;
import com.xyz.product.model.Categories;
import com.xyz.product.model.Products;
import com.xyz.product.model.SubCategories;
import com.xyz.product.model.Tags;
import com.xyz.product.repository.ProductRepository;
import com.xyz.product.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ApiResponse apiResponse;

    @Transactional
    public ApiResponse getProductsSearch(String keyword) {
        List<Search> searchResult = productRepository.productSearch(keyword);
        if (Objects.nonNull(searchResult) && !searchResult.isEmpty()) {
            apiResponse.setMessage(searchResult);
            apiResponse.setCode(HttpURLConnection.HTTP_OK);
        } else {
            apiResponse.setMessage("No result found for '" + keyword + "', Please change you search phrase");
            apiResponse.setCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return apiResponse;
    }

    public ApiResponse getAllProducts() {
        List<Products> products = productRepository.findAll();
        if (!products.isEmpty()) {
            apiResponse.setCode(HttpURLConnection.HTTP_OK);
            apiResponse.setMessage(products);
        } else {
            apiResponse.setCode(HttpURLConnection.HTTP_NO_CONTENT);
            apiResponse.setMessage("No Products available.");
        }
        return apiResponse;
    }

    public ApiResponse getAllProductById(Long id) {
        Optional<Products> products = productRepository.findById(id);
        if (products.isPresent()) {
            apiResponse.setCode(HttpURLConnection.HTTP_OK);
            apiResponse.setMessage(products.get());
        } else {
            apiResponse.setCode(HttpURLConnection.HTTP_NO_CONTENT);
            apiResponse.setMessage("No Products available.");
        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse saveProduct(Products product) {
        for (Categories category : product.getCategories()) {
            category.setProduct(product);
            for (SubCategories subCategory : category.getSubCategories()) {
                subCategory.setCategory(category);
            }
        }
        for (Tags tag : product.getTags()) {
            tag.setProduct(product);
        }
        Products SaveProduct = productRepository.save(product);
        apiResponse.setCode(HttpURLConnection.HTTP_ACCEPTED);
        apiResponse.setMessage(SaveProduct);
        return apiResponse;
    }
}
