package com.groupproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private long roleId;

    @Column(name="type")
    private String type;

    @OneToOne(mappedBy = "role",fetch = FetchType.LAZY)//cascade = CascadeType.ALL, orphanRemoval = true laze solves the more than one row with the same id
    @JsonIgnore
    private Account account;


}
