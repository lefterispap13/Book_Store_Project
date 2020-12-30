package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="account_purchase_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="purchase_id")
    private double purchaseId;

    @Column(name="purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name="euros_spent")
    private double eurosSpent;

    @Column(name="purchased_coins")
    private double purchasedCoins;

    @ManyToOne
    @JoinColumn(name="account_id",referencedColumnName="account_id",nullable=false)
    private Account account;
}
