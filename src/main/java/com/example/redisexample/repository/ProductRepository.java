package com.example.redisexample.repository;

import com.example.redisexample.model.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private static final String HASH_KEY="Product";
    private final RedisTemplate<String,Object> redisTemplate;

    public ProductRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Object> findAll(){

        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProductById(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "Deleted";
    }
}
