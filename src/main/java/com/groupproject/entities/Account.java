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

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="email")
    private String email;

    @Column(name="gender")
    private String gender;


    @OneToMany(mappedBy = "account")
    private Set<Coins> coins;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private Role role;

    @OneToMany(mappedBy = "account")
    private Set<Order> orders;

    public Account(String username, String password, String firstName,
                   String lastName, Date dateOfBirth, String email, String gender) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
    }
}
