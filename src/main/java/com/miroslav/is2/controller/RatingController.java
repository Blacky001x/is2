package com.miroslav.is2.controller;

import com.miroslav.is2.model.Category;
import com.miroslav.is2.model.Rating;
import com.miroslav.is2.model.User;
import com.miroslav.is2.repository.RatingRepository;
import com.miroslav.is2.service.RatingService;
import com.miroslav.is2.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.security.Principal;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;
    private UserService userService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Rating> post(@RequestBody Rating rating, Principal principal) {
        System.out.println("HEY, THERE. AT YOUR SERVICE");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        Rating result = ratingService.save(rating, principal);
//        Rating result = new Rating();

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
