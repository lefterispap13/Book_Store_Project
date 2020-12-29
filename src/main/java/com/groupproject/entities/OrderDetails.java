package com.groupproject.entities;

import javax.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_details_id;
}
