/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo4.reto3.repository;



import com.ciclo4.reto3.cruprepository.OrderCrupRepository;
import com.ciclo4.reto3.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author blink
 */
@Repository
public class OrderRepository {
    
     @Autowired
     private OrderCrupRepository CrudRepository;
     
    public List<Order> getAll() {
       return CrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(Integer id) {
        return CrudRepository.findById(id);
    }
    
    public Order save(Order order) {
        return CrudRepository.save(order);
    }
    
    public void update(Order order){
        CrudRepository.save(order);
    }

    
    public void delete(Integer id) {
        CrudRepository.deleteById(id);
    }
    
      public List<Order> getOrderByZone(String zone){
        return CrudRepository.findBySalesManZone(zone);
    }
}
