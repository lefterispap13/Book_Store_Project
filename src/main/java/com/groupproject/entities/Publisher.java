package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="publisher_id")
    private Long publisherId;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
}
