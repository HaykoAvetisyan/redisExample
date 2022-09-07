package com.example.redisexample.endpoint;

import com.example.redisexample.model.Product;
import com.example.redisexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
@RequiredArgsConstructor
public class ProductEndpoint {

    public final ProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping
    public List<Object> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        return productRepository.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String removeById(@PathVariable int id){
        return productRepository.deleteProductById(id);
    }

}
