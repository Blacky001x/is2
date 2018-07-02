package com.miroslav.is2.controller;

import com.miroslav.is2.model.Temp;
import com.miroslav.is2.model.User;
import com.miroslav.is2.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "OK";
    }

    @GetMapping("/lool")
    public ResponseEntity<Temp> lool() {
       return new ResponseEntity<Temp>( new Temp ( "THIS IS .. SPRING!" ), HttpStatus.OK);
    }

    @GetMapping("/nece")
    public ResponseEntity<Temp> nece() {
        return new ResponseEntity<Temp>( new Temp ( "CONGRATS! YOU'RE AUTHORIZED!" ), HttpStatus.OK);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> register(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        User saved = userService.findUserByEmail(user.getEmail());
        if (saved != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        saved = userService.saveUser(user);
        return new ResponseEntity<>(saved, headers, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Temp> test(Principal principal) {
        System.out.println(principal.getName());
        return new ResponseEntity<>( new Temp ( principal.getName()), HttpStatus.OK);
    }

}
