package com.groupproject.entities;


import javax.persistence.*;

@Entity
@Table(name="publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publisher_id;


}
