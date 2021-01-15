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
    boolean createOrder(OrderRequest request);

//    //update order with id
//    OrderRequest updateOrder(Long id, OrderRequest request);

    //delete order with id
    boolean deleteById(Long id);
}
