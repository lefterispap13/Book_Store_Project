package com.groupproject.services;

import com.groupproject.entities.Book;
import com.groupproject.entities.Category;
import com.groupproject.repository.BookRepository;
import com.groupproject.repository.CategoryRepository;
import com.groupproject.requests.CategoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    // list of the categories
    @Override
    public List<Category> getAll() {
        log.info("Ready to found all the categories");
        return categoryRepository.findAll();
    }

    // get a category by id
    @Override
    public Category getById(Long id) {
        log.info("ready to find the category with the id {}",id);
        return categoryRepository.findById(id).orElse(null);
    }



    @Override
    public void createNewCategory(CategoryRequest request) {
        log.info("Ready to create a category. The request is {}",request);
        // Find the books and add them to a list
        List<Long> bookIds = request.getBookIds();
        Set<Book> booksSet=new HashSet<>();
        log.info("Ready to find all the books");
        for(Long current:bookIds){
            Book book=bookRepository.findById(current).orElse(null);
            log.info("The book is{}",book);
            booksSet.add(book);
        }
        log.info("Ready to save the new category");
        Category category=new Category(request.getType(),booksSet);
        categoryRepository.save(category);
        log.info("Saved successfully");
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        log.info("Ready to delete a category");
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            log.info("category deleted successfully");
            return true;
        }
        log.info("category has not deleted successfully");
        return false;
    }
}
