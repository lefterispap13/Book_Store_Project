package com.groupproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private long orderId;

    @Column(name="order_date")
    private Date orderDate; //LocalDateTime

    @ManyToOne
    @JoinColumn(name="account_id",nullable=false)
    private Account account;

    @Column(name="total_coins")
    private double totalCoins;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderDetails> orderDetails;

    public Order(Long orderId,Date orderDate, Account account, double totalCoins) { //LocalDateTime
        this.orderId=orderId;
        this.orderDate = orderDate;
        this.account = account;
        this.totalCoins = totalCoins;
    }

    public Order(Date orderDate, Account account, double totalCoins, Set<OrderDetails> orderDetails) { //LocalDateTime
        this.orderDate = orderDate;
        this.account = account;
        this.totalCoins = totalCoins;
        this.orderDetails = orderDetails;
    }
}
