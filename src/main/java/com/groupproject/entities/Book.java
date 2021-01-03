package com.groupproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

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
    @JsonIgnore
    private Pricing pricing;

    //author_id(fk)
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonIgnore
    private Set<Author> authors;

    //publisher_id(fk) ??
    @ManyToOne
    @JoinColumn(name="publisher_id",nullable=false)
    @JsonIgnore
    private Publisher publisher;

    //categories_id(fk)
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private Set<Category> categories;

    //languages_id(fk)
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    @JsonIgnore
    private Set<Language> languages;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderDetails> orderDetails;

    public Book(String title, String pages, Date publicationDate, String description,
                double rating, String isbn13, Pricing pricing, Set<Author> authors,
                Publisher publisher, Set<Category> categories, Set<Language> languages,
                Set<OrderDetails> orderDetails) {
        this.title = title;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.description = description;
        this.rating = rating;
        this.isbn13 = isbn13;
        this.pricing = pricing;
        this.authors = authors;
        this.publisher = publisher;
        this.categories = categories;
        this.languages = languages;
        this.orderDetails = orderDetails;
    }

    public Book(String title, String pages, Date publicationDate, String description,
                double rating, String isbn13, Pricing pricing, Publisher publisher) {
        this.title = title;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.description = description;
        this.rating = rating;
        this.isbn13 = isbn13;
        this.pricing = pricing;
        this.publisher = publisher;
    }
}
