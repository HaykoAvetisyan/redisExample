//package com.example.redisexample.endpoint;
//
//import static org.mockito.Mockito.anyInt;
//import static org.mockito.Mockito.when;
//
//import com.example.redisexample.model.Product;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@ContextConfiguration(classes = {ProductEndpoint.class})
//@ExtendWith(SpringExtension.class)
//class ProductEndpointTest {
//    @Autowired
//    private ProductEndpoint productEndpoint;
//
//    @MockBean
//    private ProductRepository productRepository;
//
//
//    @Test
//    void testFindById() throws Exception {
//        when(productRepository.findProductById(anyInt())).thenReturn(new Product(1, "Name", 1, 1L));
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product/v1/{id}", 1);
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"quantity\":1,\"price\":1}"));
//    }
//
//
//    @Test
//    void testGetAllProducts() throws Exception {
//        when(productRepository.findAll()).thenReturn(new ArrayList<>());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product/v1");
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
//    }
//
//
//    @Test
//    void testGetAllProducts2() throws Exception {
//        when(productRepository.findAll()).thenReturn(new ArrayList<>());
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/product/v1");
//        getResult.characterEncoding("Encoding");
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(getResult)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
//    }
//
//    @Test
//    void testRemoveById() throws Exception {
//        when(productRepository.deleteProductById(anyInt())).thenReturn("42");
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/product/v1/{id}", 1);
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
//                .andExpect(MockMvcResultMatchers.content().string("42"));
//    }
//
//    @Test
//    void testRemoveById2() throws Exception {
//        when(productRepository.deleteProductById(anyInt())).thenReturn("42");
//        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/product/v1/{id}", 1);
//        deleteResult.characterEncoding("Encoding");
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(deleteResult)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
//                .andExpect(MockMvcResultMatchers.content().string("42"));
//    }
//
//
//    @Test
//    void testSave() throws Exception {
//        when(productRepository.findAll()).thenReturn(new ArrayList<>());
//
//        Product product = new Product();
//        product.setId(1);
//        product.setName("Name");
//        product.setPrice(1L);
//        product.setQuantity(1);
//        String content = (new ObjectMapper()).writeValueAsString(product);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product/v1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(productEndpoint)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
//    }
//}
//
