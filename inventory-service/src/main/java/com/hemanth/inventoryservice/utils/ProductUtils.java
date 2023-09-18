package com.hemanth.inventoryservice.utils;

import com.hemanth.inventoryservice.entities.ProductEntity;
import com.hemanth.inventoryservice.model.CreateProductRequest;
import com.hemanth.inventoryservice.model.ProductResponse;
import com.hemanth.inventoryservice.model.UpdateProductRequest;

public class ProductUtils {


    public static ProductResponse entityToDto(ProductEntity product){
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .skuCode(product.getSkuCode())
                .quantity(product.getQuantity())
                .build();
    }

    public static ProductEntity dtoToEntityOnCreate(CreateProductRequest productRequest){
        return ProductEntity.builder()
                .name(productRequest.getName())
                .skuCode(productRequest.getSkuCode())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
    }

    public static ProductEntity dtoToEntityOnUpdate(UpdateProductRequest productRequest){
        return ProductEntity.builder()
                .productId(productRequest.getProductId())
                .name(productRequest.getName())
                .skuCode(productRequest.getSkuCode())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
    }
}
