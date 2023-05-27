package com.hoaxify.ws.controller;

import com.hoaxify.ws.constraint.CurrentUser;
import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public Result<?> handleAuthentication(@CurrentUser User user){

        return this.authService.handleAuthentication(user);
    }
}
