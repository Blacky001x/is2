package com.miroslav.is2.service.impl;

import com.miroslav.is2.model.Fact;
import com.miroslav.is2.repository.FactRepository;
import com.miroslav.is2.service.FactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FactServiceImpl implements FactService {

    private FactRepository factRepository;

    public FactServiceImpl(FactRepository factRepository) {
        this.factRepository = factRepository;
    }

    @Override
    public List<Fact> findAll() {
        return factRepository.findAll();
    }

    @Override
    public List<Fact> findByCategory(int id) {
        return factRepository.findByCategory(id);
    }

    @Override
    public Fact findById(int id) {
        return factRepository.findById(id).orElse(null);
    }

    @Override
    public Fact getRandom() {
        List<Fact> facts = factRepository.findByIsAllowedTrue();
        int size = facts.size();
        if (size == 0) {
            return null;
        }
        Random r = new Random();
        return facts.get(r.nextInt(size));
    }

    @Override
    public Fact getRandomInCategory(int categoryId) {
        List<Fact> factsInCategory = findByCategory(categoryId);
        int size = factsInCategory.size();
        Random r = new Random();
        return factsInCategory.get(r.nextInt(size));
    }

    @Override
    public Fact save(Fact fact) {
        return factRepository.save(fact);
    }

    @Override
    public List<Fact> getAllUnapproved() {
        return factRepository.findAllUnapproved();
    }

    @Override
    public void updateUnapproved(List<Fact> facts) {
        for (Fact fact : facts) {
            Fact f = factRepository.getOne(fact.getId());
            f.setAllowed(fact.isAllowed());
            factRepository.save(f);
        }
    }
}
