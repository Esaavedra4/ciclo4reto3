/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ciclo4.reto3.cruprepository;


import com.ciclo4.reto3.model.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author blink
 */
public interface ProductCrudRepository extends MongoRepository<Product, String> {
    
    public List<Product> findByPrice(double price);
    public List<Product> findByDescriptionContainingIgnoreCase(String description);
    
    
}
