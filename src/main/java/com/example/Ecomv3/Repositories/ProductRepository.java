package com.example.Ecomv3.Repositories;

import com.example.Ecomv3.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
