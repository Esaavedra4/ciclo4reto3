/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo4.reto3.service;


import com.ciclo4.reto3.model.Product;
import com.ciclo4.reto3.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blink
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.getProduct(id);
    }

    public Product save(Product product) {
        if (product.getReference() == null) {
            return productRepository.save(product);
        } else {
            Optional<Product> e = productRepository.getProduct(product.getReference());
            if (e.isEmpty()) {
                return productRepository.save(product);
            } else {
                return product;
            }
        }
    }

    public Product update(Product product) {

        if (product.getReference() == null) {
            return productRepository.save(product);
        } else {
            Optional<Product> producto = productRepository.getProduct(product.getReference());
            
            if (!producto.isEmpty()) {
                if (product.getCategory() != null) {
                    producto.get().setCategory(product.getCategory());
                }
                if (product.getSize() != null) {
                    producto.get().setSize(product.getSize());
                }
                if (product.getDescription() != null) {
                    producto.get().setDescription(product.getDescription());
                }
                if (product.getPhotography() != null) {
                    producto.get().setPhotography(product.getPhotography());
                }
                productRepository.save(producto.get());
                return producto.get();
            } else {
                return product;
            }
        }
    }

    public boolean delete(String id) {

        Boolean aBoolean = getProduct(id).map(user -> {
            productRepository.delete(id);
            return true;
        }).orElse(aBoolean = false);

        return aBoolean;
    }
}
