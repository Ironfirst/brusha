package com.example.brusha.service;

import com.example.brusha.models.Product;
import com.example.brusha.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    // autowired annotation til repository
    @Autowired
    ProductRepository productRepository;

    // find med id parameter // giver runetimeException hvis ikke fundet
    public Product findById(Long id) {
        // metode setup til at finde product efter id // bruger optional " laver en present state hvis fundet"
        Optional<Product> productOptional = productRepository.findById(id);
        // hvis den ikke finder et match med id, kaster den en fejl
        if(!productOptional.isPresent()){
            throw new RuntimeException("Productet blev ikke fundet");
        }
        return productOptional.get();
    }

    //metode til at finde alle
    public Set<Product> findAll(){

        Set<Product> products = new HashSet<>();
        for(Product product: productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }

    // ved create generere hibernate id
    public void create(Product product) {
        productRepository.save(product);
    }

    // ved update skal id være sat
    public void update(Product product){
        productRepository.save(product);
    }



}
