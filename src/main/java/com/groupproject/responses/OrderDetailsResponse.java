package com.groupproject.responses;

import com.groupproject.entities.OrderDetails;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsResponse extends Response{

    private List<OrderDetails> orderDetailsList;
    private OrderDetails orderDetails;

    public OrderDetailsResponse(String msg, List<OrderDetails> orderDetailsList){
        super(msg);
        this.orderDetailsList=orderDetailsList;
    }

    public OrderDetailsResponse(String msg, OrderDetails orderDetails){
        super(msg);
        this.orderDetails=orderDetails;
    }
}