/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo4.reto3.repository;


import com.ciclo4.reto3.cruprepository.ProductCrudRepository;
import com.ciclo4.reto3.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blink
 */

@Repository
public class ProductRepository {
    
    @Autowired
     private ProductCrudRepository CrudRepository;
    
    public List<Product> getAll() {
        return CrudRepository.findAll();
    }
    
    public Optional<Product> getProduct(String id) {
        return CrudRepository.findById(id);
    }
    
    public Product save(Product product) {
        return CrudRepository.save(product);
    }
    
    public void delete(String id) {
        CrudRepository.deleteById(id);
    }
    
    public List<Product> getByPrice(double price){
       return CrudRepository.findByPrice(price);
    }

    public List<Product> getByDescriptionContains(String description){
       return CrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
