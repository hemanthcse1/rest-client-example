package com.hemanth.inventoryservice.repository;

import com.hemanth.inventoryservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {



   public ProductEntity findByProductId(String productId);
}
