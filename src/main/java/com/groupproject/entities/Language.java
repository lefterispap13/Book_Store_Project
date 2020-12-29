package com.groupproject.entities;

import javax.persistence.*;


@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long language_id;

}
