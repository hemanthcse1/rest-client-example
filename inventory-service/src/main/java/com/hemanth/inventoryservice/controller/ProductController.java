package com.hemanth.inventoryservice.controller;

import com.hemanth.inventoryservice.model.CreateProductRequest;
import com.hemanth.inventoryservice.model.ProductResponse;
import com.hemanth.inventoryservice.model.UpdateProductRequest;
import com.hemanth.inventoryservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest){
        return ResponseEntity.ok(productService.createProduct(createProductRequest));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest updateProductRequest){
        return ResponseEntity.ok(productService.updateProduct(updateProductRequest));
    }

    @DeleteMapping ("/{productId}")
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable("productId") String productId){
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productId") String productId){
        return ResponseEntity.ok(productService.findProductById(productId));
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }




}
