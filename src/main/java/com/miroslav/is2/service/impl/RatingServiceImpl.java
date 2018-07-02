package com.miroslav.is2.service.impl;

import com.miroslav.is2.model.Fact;
import com.miroslav.is2.model.Rating;
import com.miroslav.is2.model.User;
import com.miroslav.is2.repository.FactRepository;
import com.miroslav.is2.repository.RatingRepository;
import com.miroslav.is2.repository.UserRepository;
import com.miroslav.is2.service.RatingService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private UserRepository userRepository;
    private FactRepository factRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, UserRepository userRepository, FactRepository factRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.factRepository = factRepository;
    }

    @Override
    public Rating save(Rating rating, Principal principal) {
        String username = principal.getName();
        int userId = userRepository.findByEmail(username).getId();

        rating.setUserId(userId);

        return ratingRepository.save(rating);
//        return rating;
    }
}
