package com.hoaxify.ws.controller;

import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping("/save")
  public void save(@RequestBody @Valid UserRequest userRequest) {

    userService.save(userRequest);
  }
}
