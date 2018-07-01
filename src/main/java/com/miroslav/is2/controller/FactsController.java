package com.miroslav.is2.controller;

import com.miroslav.is2.model.Category;
import com.miroslav.is2.model.Fact;
import com.miroslav.is2.service.CategoryService;
import com.miroslav.is2.service.FactService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facts")
public class FactsController {

    private FactService factService;
    private CategoryService categoryService;

    public FactsController(FactService factService, CategoryService categoryService) {
        this.factService = factService;
        this.categoryService = categoryService;
    }

    @GetMapping("/next")
    public ResponseEntity<Fact> next() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        Fact fact = factService.getRandom();

        return new ResponseEntity<>(fact, headers, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        List<Category> categories = categoryService.findAll();

        return new ResponseEntity<>(categories, headers, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Fact> post(@RequestBody Fact fact) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        Category detachedCategory = fact.getCategory();
        Category attached = categoryService.findByName(detachedCategory.getName());
        fact.setCategory(attached);
        fact = factService.save(fact);

        return new ResponseEntity<>(fact, headers, HttpStatus.OK);
    }

}
