package com.example.redisexample.service;

import com.example.redisexample.model.Product;
import com.example.redisexample.repository.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl  implements ProductService{

    private static final String HASH_KEY = "Product";
    private final RedisTemplate<String, Set<Object>> redisTemplate;
//    private final ZSetOperations<String, Set<Object>> zSetOperations;

    private final ProductRepo productRepo;

    public ProductServiceImpl(RedisTemplate<String, Set<Object>> redisTemplate, ProductRepo productRepo) {
        this.redisTemplate = redisTemplate;
        this.productRepo = productRepo;
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);

    }

    @Override
    public List<Object> findAll() {
        return Collections.singletonList(productRepo.findAll());
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public String deleteProductById(int id) {
        productRepo.deleteById(id);
        return "removed";
    }

    @Override
    public List<Product> findPage(PageRequest pageRequest) {
        return productRepo.findAll(pageRequest).get().collect(Collectors.toList());
    }



//
//    public Product save(Product product) {
//        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
//        return product;
//    }
//
//    public List<Object> findAll() {
////        RedisOperations<String, Object> operations = redisTemplate.opsForZSet().getOperations();
////        List<Object> exec = operations.exec();
////        System.out.println(exec);
//        return redisTemplate.opsForHash().values(HASH_KEY);
//    }
//
//
////    public List<Object> findFirst5(){
////        Set<Object> range = zSetOperations.range(HASH_KEY, 1, 3);
////        List<Object> array = new ArrayList<>();
////        array.addAll(range);
////
////
////        return array;
////
////    }
//
//    public void findPage() {
//         zSetOperations.range(HASH_KEY, 1, 3);
//    }
//
//
//    public Product findProductById(int id) {
//        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
//    }
//
//    public String deleteProductById(int id) {
//        redisTemplate.opsForHash().delete(HASH_KEY, id);
//        return "Deleted";
//    }

   
}
