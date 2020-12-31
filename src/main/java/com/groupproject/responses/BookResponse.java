package com.groupproject.responses;

import com.groupproject.entities.Author;
import com.groupproject.entities.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookResponse extends Response{

    private List<Book> books;
    private Book book;

    public BookResponse(String msg, List<Book> books){
        super(msg);
        this.books=books;
    }

    public BookResponse(String msg, Book book){
        super(msg);
        this.book=book;
    }

}
