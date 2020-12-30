package com.groupproject.responses;

import com.groupproject.entities.Account;
import com.groupproject.entities.Author;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponse extends Response{

    private List<Author> authors;
    private Author author;

    public AuthorResponse(String msg, List<Author> authors){
        super(msg);
        this.authors=authors;
    }

    public AuthorResponse(String msg, Author author){
        super(msg);
        this.author=author;
    }
}
