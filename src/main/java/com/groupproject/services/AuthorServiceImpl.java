package com.groupproject.services;


import com.groupproject.entities.Author;
import com.groupproject.repository.AuthorRepository;
import com.groupproject.requests.AuthorRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements IAuthorService{

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }


    @Override
    public boolean newAuthor(AuthorRequest request) {
        log.info("Ready to insert a new Author");
        Author author=new Author(request.getFirstName(), request.getLastName(), request.getCountry());
        Author newAuthor=authorRepository.save(author);
        log.info("The new author is {}",newAuthor);
        log.info("The author has been inserted to the DB");
        return true;
    }
    //???
    @Override
    public boolean deleteAuthor(Long id) {
        log.info("Ready to delete an author");
        if (authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            log.info("author deleted successfully");
            return true;
        }
        log.info("author has not deleted successfully");
        return false;
    }
}
