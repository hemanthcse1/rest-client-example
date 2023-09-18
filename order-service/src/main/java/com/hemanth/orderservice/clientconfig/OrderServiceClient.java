package com.hemanth.orderservice.clientconfig;

import com.hemanth.orderservice.dto.CreateProductRequest;
import com.hemanth.orderservice.dto.Product;
import com.hemanth.orderservice.dto.ProductResponse;
import com.hemanth.orderservice.dto.UpdateProductRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderServiceClient {

    private final RestClient restClient;


    public OrderServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public ProductResponse createProduct(CreateProductRequest product) {
        return restClient.post()
                .uri("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(ProductResponse.class);
    }

    public List<ProductResponse> getAllProducts() {
        return restClient.get()
                .uri("/api/product")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductResponse>>() {
                });
    }

    public ProductResponse findProductById(String productId) {
        return restClient.get()
                .uri("/api/product/{productId}", productId)
                .retrieve()
                .body(ProductResponse.class);
    }

    public ProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        return restClient.put()
                .uri("/api/product")
                .body(UpdateProductRequest.class)
                .retrieve()
                .body(ProductResponse.class);
    }

    public String deleteProduct(String productId) {
        restClient.delete()
                .uri("/api/product/{productId}", productId)
                .retrieve()
                .toBodilessEntity();

        return "Product deleted successfully!";
    }
}
