package com.groupproject.entities;


import javax.persistence.*;

@Entity
@Table(name="pricing")
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pricing_id;




}
