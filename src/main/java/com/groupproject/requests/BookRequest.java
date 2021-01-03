package com.groupproject.requests;

import com.groupproject.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;
    private String pages;
    private Date publicationDate;
    private String description;
    private double rating;
    private String isbn13;
    private Publisher publisher;
    private Pricing pricing;


//    private List<Long> authorIds;

//    private List<Long> categoryIds;
//    private List<Long> languageIds;
//    private List<Long> orderDetailsIds;
//
//    //???
//    private Set<Author> authors;
//    private Set<Category> categories;
//    private Set<Language> languages;
//    private Set<OrderDetails> orderDetails;
//
//    public BookRequest(String title, String pages,
//                       Date publicationDate, String description,
//                       double rating, String isbn13, Publisher publisher,
//                       Pricing pricing, Set<Author> authors,
//                       Set<Category> categories, Set<Language> languages,
//                       Set<OrderDetails> orderDetails) {
//        this.title = title;
//        this.pages = pages;
//        this.publicationDate = publicationDate;
//        this.description = description;
//        this.rating = rating;
//        this.isbn13 = isbn13;
//        this.publisher = publisher;
//        this.pricing = pricing;
//        this.authors = authors;
//        this.categories = categories;
//        this.languages = languages;
//        this.orderDetails = orderDetails;
//    }
}
