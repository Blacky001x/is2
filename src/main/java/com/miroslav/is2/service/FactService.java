package com.miroslav.is2.service;

import com.miroslav.is2.model.Fact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactService {

    List<Fact> findAll();

    List<Fact> findByCategory(int id);

    Fact findById(int id);

    Fact getRandom();

    Fact getRandomInCategory(int categoryId);

    Fact save(Fact fact);

    List<Fact> getAllUnapproved();

    void updateUnapproved(List<Fact> facts);
}
