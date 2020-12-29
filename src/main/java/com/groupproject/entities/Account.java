package com.groupproject.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long account_id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

}
