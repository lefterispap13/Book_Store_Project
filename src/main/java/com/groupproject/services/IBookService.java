package com.groupproject.services;

import com.groupproject.entities.Book;
import com.groupproject.requests.BookRequest;

import java.util.List;

public interface IBookService {

    // get the list for all books
    List<Book> getAll();

    //get a book by id
    Book getBookById(Long id);

    // create new book
    void createNewBook(BookRequest request);

    // update an existing book
    Book updateBook(Long id,BookRequest request);

    // delete a book from id
    boolean deleteBookById(Long id);
}
