package com.groupproject.services;

import com.groupproject.entities.Order;
import com.groupproject.repository.OrderRepository;
import com.groupproject.requests.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createOrder(OrderRequest request) {
        log.info("Ready to insert a new Author");
        Order order=new Order(request.getOrderId(),request.getOrderDate(),request.getAccount(), request.getTotalCoins(), request.getOrderDetails());
        Order newOrder=new orderRepository.save(order);
        log.info("The new order is {}",newOrder);
        log.info("The order has been inserted to the DB");
        return true;

    }

    @Override
    public OrderRequest updateOrder(Long id, OrderRequest request) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
