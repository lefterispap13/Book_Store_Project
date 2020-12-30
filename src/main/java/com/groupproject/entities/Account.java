package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long accountId;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="gender")
    private String gender;


    @Column(name ="coins")
    private double coins;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private Role role;

    @OneToMany(mappedBy = "account")
    private Set<Order> orders;

    @OneToMany(mappedBy = "account")
    private Set<PurchaseHistory> purchaseHistorySet;

    public Account(String username, String password, String firstName,
                   String lastName, Date dateOfBirth, double coins,String email, String gender) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.coins=coins;
        this.email = email;
        this.gender = gender;
    }
}
