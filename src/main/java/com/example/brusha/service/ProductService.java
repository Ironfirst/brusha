package com.example.brusha.service;

import com.example.brusha.models.Product;
import com.example.brusha.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Long id)

}
