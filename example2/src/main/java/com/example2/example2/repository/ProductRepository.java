package com.example2.example2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.example2.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
