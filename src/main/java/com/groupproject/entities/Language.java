package com.groupproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long language_id;

    @Column(name="language_type")
    private String languageType;

    @ManyToMany(mappedBy="languages")
    private Set<Book> book;
}
