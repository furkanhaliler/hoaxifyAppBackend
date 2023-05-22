package com.hoaxify.ws.controller;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/save")
  public Result<UserDto> save(@RequestBody @Valid UserRequest userRequest) {

    return userService.save(userRequest);
  }
}
