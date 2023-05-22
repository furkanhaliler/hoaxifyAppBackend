package com.hoaxify.ws.controller;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public Result<?> handleAuthentication(@RequestHeader(name = "Authorization", required = false) String authorization){

        return this.authService.handleAuthentication(authorization);
    }
}
