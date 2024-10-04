package com.example.Ecomv3.Repositories;

import com.example.Ecomv3.DTO.ProductListDTO;
import com.example.Ecomv3.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.example.Ecomv3.DTO.ProductListDTO(p.id, p.name, p.description, p.price, p.quantity, p.image) FROM Product p")
    List<ProductListDTO> findAllWithoutComments();
}
