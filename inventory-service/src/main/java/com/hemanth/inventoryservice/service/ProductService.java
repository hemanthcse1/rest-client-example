package com.hemanth.inventoryservice.service;

import com.hemanth.inventoryservice.entities.ProductEntity;
import com.hemanth.inventoryservice.model.CreateProductRequest;
import com.hemanth.inventoryservice.model.ProductResponse;
import com.hemanth.inventoryservice.model.UpdateProductRequest;
import com.hemanth.inventoryservice.repository.ProductRepository;
import com.hemanth.inventoryservice.utils.ProductUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(CreateProductRequest product) {


        ProductEntity createProduct = ProductEntity.builder()
                .productId(UUID.randomUUID().toString())
                .name(product.getName())
                .price(product.getPrice())
                .skuCode(product.getSkuCode())
                .quantity(product.getQuantity())
                .build();

        ProductEntity savedProduct = productRepository.save(createProduct);

        return ProductUtils.entityToDto(savedProduct);
    }

    public ProductResponse updateProduct(UpdateProductRequest productRequest) {
        ProductEntity existingEntity = productRepository.findByProductId(productRequest.getProductId());

        ProductEntity updatedProduct = null;

        if (existingEntity != null) {


            ProductEntity updateProduct = ProductEntity.builder().id(existingEntity.getId())
                    .name(productRequest.getName())
                    .price(productRequest.getPrice())
                    .skuCode(productRequest.getSkuCode())
                    .quantity(productRequest.getQuantity())
                    .build();

            updatedProduct = productRepository.save(updateProduct);
        }

        return ProductUtils.entityToDto(updatedProduct);
    }

    public Map<String, String> deleteProduct(String id) {
        Map<String, String> response = new HashMap<>();

        ProductEntity productEntity = productRepository.findByProductId(id);

        if (productEntity != null) {

            productRepository.delete(productEntity);

            response.put("message", "Product deleted successfully");
        } else {
            response.put("message", "Invalid product id");
        }

        return response;
    }


    public ProductResponse findProductById(String id) {
        ProductEntity product = productRepository.findByProductId(id);

        if (product != null) {

            return ProductUtils.entityToDto(product);

        }

        return null;
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(ProductUtils::entityToDto).toList();
    }


}
