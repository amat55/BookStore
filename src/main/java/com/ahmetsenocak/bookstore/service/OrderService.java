package com.ahmetsenocak.bookstore.service;

import com.ahmetsenocak.bookstore.model.Book;
import com.ahmetsenocak.bookstore.model.Order;
import com.ahmetsenocak.bookstore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private final OrderRepository orderRepository;


    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAndOrder(List<Integer> bookIdList, String userName) {

        Double totalPrice = bookIdList.stream()
                .map(bookService::findBookById)
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(Double.valueOf(0.0)))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .bookList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        return orderRepository.save(order);
    }
}
