package com.example.product_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_usuer_order.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
 