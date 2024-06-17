package com.example.product_MARCO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.product_MARCO.model.Order;
import com.example.product_MARCO.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    // GET a single order by idCommande
    @GetMapping("/{idCommande}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long idCommande) {
        Optional<Order> order = orderRepository.findById(idCommande);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // DELETE an order by idCommande
    @DeleteMapping("/{idCommande}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long idCommande) {
        if (orderRepository.existsById(idCommande)) {
            orderRepository.deleteById(idCommande);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
