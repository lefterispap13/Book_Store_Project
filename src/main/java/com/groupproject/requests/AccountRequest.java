package com.groupproject.requests;

import java.util.Date;

import com.groupproject.entities.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String gender;
    private double coins;
    private Role role;

    public AccountRequest(String username, String password, String firstName, String lastName, Date dateOfBirth, String email, String gender) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
    }

    public AccountRequest(String username, String password, String firstName, String lastName, Date dateOfBirth, String email, String gender, double coins) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.coins = coins;
    }
//    private Role role;
    public AccountRequest(String username, String password, String firstName, String lastName, Date dateOfBirth, String email, String gender, double coins,Role role) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.coins = coins;
        this.role=role;
    }
}
