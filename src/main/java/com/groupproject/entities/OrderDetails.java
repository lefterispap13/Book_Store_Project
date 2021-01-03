package com.groupproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_details_id")
    private long orderDetailsId;

    @ManyToOne
    @JoinColumn(name="order_id",nullable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="book_id",referencedColumnName="book_id",nullable=false)
    private Book book;

    @Column(name="price_after_discount")
    private double priceAfterDiscount;

    public OrderDetails(Order order, Book book, double priceAfterDiscount) {
        this.order = order;
        this.book = book;
        this.priceAfterDiscount = priceAfterDiscount;
    }
}
