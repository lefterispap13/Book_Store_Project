package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="coins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coins {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="coins_id")
    private double coinsId;

    @Column(name="starting_coins")
    private double startingCoins;

    @Column(name="purchased_coins")
    private double purchasedCoins;

    @ManyToOne
    @JoinColumn(name="account_id",nullable=false)
    private Account account;
}
