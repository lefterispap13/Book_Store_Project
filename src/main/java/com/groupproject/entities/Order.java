package com.groupproject.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

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

    public Order(Long orderId, LocalDateTime orderDate, Account account, double totalCoins) { //LocalDateTime
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.account = account;
        this.totalCoins = totalCoins;
    }

    public Order(LocalDateTime orderDate, Account account, double totalCoins, Set<OrderDetails> orderDetails) { //LocalDateTime
        this.orderDate = orderDate;
        this.account = account;
        this.totalCoins = totalCoins;
        this.orderDetails = orderDetails;
    }

}
