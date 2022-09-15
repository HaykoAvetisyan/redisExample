package com.example.redisexample.repository;

import com.example.redisexample.model.Product;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface ProductRepo extends KeyValueRepository<Product,Integer> {


}
