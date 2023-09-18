package com.hemanth.orderservice.controller;

import com.hemanth.orderservice.clientconfig.OrderServiceClient;
import com.hemanth.orderservice.dto.CreateProductRequest;
import com.hemanth.orderservice.dto.ProductResponse;
import com.hemanth.orderservice.dto.UpdateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    private final OrderServiceClient orderServiceClient;

    public OrderController(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }



    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest){
        return ResponseEntity.ok(orderServiceClient.createProduct(createProductRequest));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest updateProductRequest){
        return ResponseEntity.ok(orderServiceClient.updateProduct(updateProductRequest));
    }

    @DeleteMapping ("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId){
        return ResponseEntity.ok(orderServiceClient.deleteProduct(productId));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productId") String productId){
        return ResponseEntity.ok(orderServiceClient.findProductById(productId));
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(orderServiceClient.getAllProducts());
    }
}
