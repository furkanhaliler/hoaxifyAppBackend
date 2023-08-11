package com.hoaxify.ws.controller;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/getAll")
  public Result<List<UserDto>> getUsers(){
    return userService.getAll();
  }
}
