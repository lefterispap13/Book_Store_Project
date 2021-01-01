package com.groupproject.services;

import com.groupproject.entities.Category;
import com.groupproject.repository.CategoryRepository;
import com.groupproject.requests.CategoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    // list
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createNewCategory(CategoryRequest request) {
        return false;
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        return false;
    }
}
