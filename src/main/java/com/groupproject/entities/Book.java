package com.groupproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name="pages")
    private String pages;

    @Column(name="publication_date")
    private Date publicationDate;

    @Column(name="description",length=10000)
    private String description;

    @Column(name="rating")
    private double rating;

    @Column(name="isbn13")
    private String isbn13;

    //book_pricing_id(fk)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pricing_id",referencedColumnName = "pricing_id")
    private Pricing pricing;

    //author_id(fk)
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    //publisher_id(fk) ??
    @ManyToOne
    @JoinColumn(name="publisher_id",nullable=false)
    private Publisher publisher;

    //categories_id(fk)
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    //languages_id(fk)
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languages;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;



}
