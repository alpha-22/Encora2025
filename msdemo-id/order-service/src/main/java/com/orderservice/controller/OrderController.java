package com.orderservice.controller;
import com.orderservice.client.ProductServiceClient;
import com.orderservice.model.Order;
import com.orderservice.repository.OrderRepository;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
   
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @PostMapping
    @Operation(summary= "create a order")
    public Order createOrder(@RequestBody Order order) {
       orderRepository.save(order);
       return order;
    }
    @GetMapping("/createorder")
    public Order createSampleOrder() {
    	Order order = new Order();
    	return order;
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
       Order order = orderRepository.findById(id).get();
       return order;
    }
    
  
}

