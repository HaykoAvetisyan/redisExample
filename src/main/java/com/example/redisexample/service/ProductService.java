package com.example.redisexample.service;

import com.example.redisexample.model.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save(Product product);

    public List<Object> findAll();

    public Optional<Product> findProductById(int id);

    public String deleteProductById(int id);

    public List<Product> findPage(PageRequest pageRequest);

}
