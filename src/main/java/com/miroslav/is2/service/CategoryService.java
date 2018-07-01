package com.miroslav.is2.service;

import com.miroslav.is2.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(int id);

    Category findByName(String name);

    Category save(Category category);
}
