package com.groupproject.responses;

import com.groupproject.entities.Order;
import java.util.List;

public class OrderResponse extends Response {

    private List<Order> orders;
    private Order order;

    public OrderResponse(String msg, List<Order> orders) {

        super(msg);
        this.orders = orders;
    }

    public OrderResponse(String msg, Order order) {

        super(msg);
        this.order = order;
    }
}
