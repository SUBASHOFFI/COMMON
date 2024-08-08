package com.gift.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.website.Modal.Product;

public interface Productrepo extends JpaRepository<Product,Integer>{
    List<Product> findByCategory(String category);
    
} 
