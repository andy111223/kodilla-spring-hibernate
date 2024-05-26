package com.kodilla.springevents.controller;

import com.kodilla.springevents.domain.ProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @PostMapping(path = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Register product: " + productDto.getProductName());
    }
}
