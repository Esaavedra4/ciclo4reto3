/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo4.reto3.service;


import com.ciclo4.reto3.model.Order;
import com.ciclo4.reto3.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blink
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return orderRepository.save(order);
        } else {
            Optional<Order> e = orderRepository.getOrder(order.getId());
            if (e.isEmpty()) {
                return orderRepository.save(order);
            } else {
                return order;
            }
        }
    }

    public Order update(Order order) {

        if (order.getId() == null) {
            return orderRepository.save(order);
        } else {
            Optional<Order> or = orderRepository.getOrder(order.getId());
            
            if (!or.isEmpty()) {
                if (order.getProducts() != null) {
                    or.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    or.get().setQuantities(order.getQuantities());
                }
                if (order.getRegisterDay() != null) {
                    or.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getSalesMan() != null) {
                    or.get().setSalesMan(order.getSalesMan());
                }
                if (order.getStatus() != null) {
                    or.get().setStatus(order.getStatus());
                }
                orderRepository.save(or.get());
                return or.get();
            } else {
                return order;
            }
        }
    }

    public boolean delete(Integer id) {

        Boolean aBoolean = getOrder(id).map(user -> {
            orderRepository.delete(id);
            return true;
        }).orElse(aBoolean = false);

        return aBoolean;
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
}
