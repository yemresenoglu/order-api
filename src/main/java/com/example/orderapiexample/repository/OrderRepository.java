package com.example.orderapiexample.repository;

import com.example.orderapiexample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
