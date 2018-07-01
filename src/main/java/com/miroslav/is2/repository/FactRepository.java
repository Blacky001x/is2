package com.miroslav.is2.repository;

import com.miroslav.is2.model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactRepository extends JpaRepository<Fact, Integer> {

    @Query("SELECT f FROM Fact f WHERE f.category=:id")
    List<Fact> findByCategory(@Param("id") int id);

    @Query("SELECT f FROM Fact f WHERE f.isAllowed=false")
    List<Fact> findAllUnapproved();
}
