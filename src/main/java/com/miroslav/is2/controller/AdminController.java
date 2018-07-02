package com.miroslav.is2.controller;

import com.miroslav.is2.model.Category;
import com.miroslav.is2.model.Fact;
import com.miroslav.is2.service.FactService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private FactService factService;

    public AdminController(FactService factService) {
        this.factService = factService;
    }

    @GetMapping("/facts/unapproved")
    public ResponseEntity<List<Fact>> getAllUnapproved() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        List<Fact> facts = factService.getAllUnapproved();

        return new ResponseEntity<>(facts, headers, HttpStatus.OK);
    }

    @PostMapping("/facts/unapproved")
    public ResponseEntity<?> updateUnapproved(@RequestBody List<Fact> facts) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        factService.updateUnapproved(facts);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
