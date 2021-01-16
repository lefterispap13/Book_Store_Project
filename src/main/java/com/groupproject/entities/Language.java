package com.groupproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private Long languageId;

    @Column(name="language_type")
    private String languageType;

    @ManyToMany(mappedBy="languages")
    @JsonIgnore
    private Set<Book> book;

    public Language(String languageType) {
        this.languageType = languageType;
    }
}
