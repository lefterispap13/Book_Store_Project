package com.groupproject.controllers;


import com.groupproject.requests.AuthorRequest;
import com.groupproject.responses.AuthorResponse;
import com.groupproject.responses.Response;
import com.groupproject.services.AuthorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value="/api/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    // get all the authors
    @GetMapping(value="/getall")
    public AuthorResponse getAll(){
        log.info("Ready to find all the Authors");
        return new AuthorResponse("Found all the authors", authorService.getAll());
    }

    // get author by id
    @GetMapping(value="/getbyid/{id}")
    public AuthorResponse getById(@PathVariable Long id){
        log.info("Ready to find the Author with id{}",id);
        return new AuthorResponse("Found the Author with the given id", authorService.getAuthorById(id));
    }

    // insert new Author
    @PostMapping(value="/new",consumes = "application/json",
            produces = "application/json")
    public Response newAuthor(@RequestBody AuthorRequest request){
        authorService.newAuthor(request);
        log.info("Ready to insert a new Author");
        return new Response("The new Author has been saved");
    }

    // delete account by id
    @DeleteMapping("/delete/{id}")
    public Response deleteAccount(@PathVariable Long id){
        log.info("Ready to delete an author");
        authorService.deleteAuthor(id);
        return new Response("The account has been deleted");
    }
}
