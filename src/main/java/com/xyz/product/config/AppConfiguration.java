package com.xyz.product.config;

import com.xyz.product.response.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ApiResponse apiResponse() {
        return new ApiResponse();
    }
}
