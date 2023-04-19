package com.ahmetsenocak.bookstore.controller;

import com.ahmetsenocak.bookstore.dto.BookOrderRequest;
import com.ahmetsenocak.bookstore.model.Order;
import com.ahmetsenocak.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //bu uygulamanin disaridan rest api olarak disaridan erisebilir hale gelitiriyor
@RequestMapping("v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        Order order = orderService.putAndOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }
}
