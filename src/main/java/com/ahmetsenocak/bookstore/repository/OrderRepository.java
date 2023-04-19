package com.ahmetsenocak.bookstore.repository;

import com.ahmetsenocak.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
