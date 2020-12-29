package com.groupproject.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long account_id;


}
