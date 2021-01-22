package com.groupproject.services;

import com.groupproject.entities.Order;
import com.groupproject.requests.OrderRequest;
import java.util.List;

public interface IOrderService {

    //list for all orders
    List<Order> getAll();

    // find order with id
    Order getOrderById(Long id);

    //new order
    Long createOrder(OrderRequest request);

    //update order with id
    Order updateOrder(Long id, OrderRequest request);

    //update order after new order details
    Order updateOrder(Long id, double totalCoins);

    //delete order with id
    boolean deleteById(Long id);
}
