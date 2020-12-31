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
        log.info("Ready to insert a new Order");
        Order order=new Order(request.getOrderDate(),request.getAccount(), request.getTotalCoins(), request.getOrderDetails());
        Order newOrder=orderRepository.save(order);
        log.info("The new order is {}",newOrder);
        log.info("The order has been inserted to the DB");
        return true;

    }

    @Override
    public OrderRequest updateOrder(Long id, OrderRequest request) {
        log.info("Ready to update the given order");
        if(orderRepository.findById(id).isPresent()){
            Order existingOrder=orderRepository.findById(id).get();
            existingOrder.setOrderDate(request.getOrderDate());//is it ok to update the order date time?
            existingOrder.setOrderDetails(request.getOrderDetails());
            existingOrder.setTotalCoins(request.getTotalCoins());
            Order updatedOrder=orderRepository.save(existingOrder);
            log.info("The updated order is {}",updatedOrder);
            log.info("The updated order has been inserted to the DB");
            return new OrderRequest(updatedOrder.getOrderDate(),updatedOrder.getAccount(), updatedOrder.getTotalCoins(),updatedOrder.getOrderDetails());
        }
        log.info("The order didn't get updated");
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        log.info("Ready to delete an Order");
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            log.info("Order successfully deleted");
            return true;
        }
        log.info("Order wasn't successfully");
        return false;
    }
}
