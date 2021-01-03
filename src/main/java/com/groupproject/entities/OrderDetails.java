package com.groupproject.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_details_id")
    private Long orderDetailsId;

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
