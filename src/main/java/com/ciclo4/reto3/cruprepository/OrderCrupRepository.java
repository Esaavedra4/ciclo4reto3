/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ciclo4.reto3.cruprepository;


import com.ciclo4.reto3.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author blink
 */
    public interface OrderCrupRepository extends MongoRepository<Order, Integer>{
             
        List<Order> findBySalesManZone(String zone);
        List<Order> findBySalesManId(Integer id);
        List<Order> findBySalesManIdAndStatus(Integer id, String status);
        List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);

}
