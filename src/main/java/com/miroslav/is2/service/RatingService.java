package com.miroslav.is2.service;

import com.miroslav.is2.model.Rating;

import java.security.Principal;

public interface RatingService {

    Rating save(Rating rating, Principal principal);

}
