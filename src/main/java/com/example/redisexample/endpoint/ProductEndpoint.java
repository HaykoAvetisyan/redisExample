package com.example.redisexample.endpoint;

import com.example.redisexample.exeption.ProductNotFoundException;
import com.example.redisexample.model.Product;
import com.example.redisexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product/v1")
@RequiredArgsConstructor
public class ProductEndpoint {

    public final ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @GetMapping
    public List<Object> getAllProducts(){

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){

        Optional<Product> productById = productService.findProductById(id);
        if(productById.isPresent()){
            return productById.get();
        }else {
            throw new ProductNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public String removeById(@PathVariable int id){
        return productService.deleteProductById(id);
    }


    @GetMapping("/page")
    public List<Product> pageAll(ModelMap map,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "3") int size) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());

        return productService.findPage(pageRequest);
    }


//    @GetMapping("/five")
//
//    public List<Object> five(){
//        return productService.findFirst5();
//    }
    //    @GetMapping("/page")
//    public Set<Object> getProducts()
//    {
//        return productService.findPage();
//    }
}
