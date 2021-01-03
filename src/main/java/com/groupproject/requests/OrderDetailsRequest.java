package com.groupproject.requests;

import com.groupproject.entities.Book;
import com.groupproject.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsRequest {
    private Order order;
    private Book book;
    private double priceAfterDiscount;
}
