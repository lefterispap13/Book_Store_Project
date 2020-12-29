package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private long orderId;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    // ????
    @ManyToOne
    @JoinColumn(name="account_id",nullable=false)
    private Account account;

    @Column(name="total_coins")
    private double totalCoins;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> orderDetails;



}
