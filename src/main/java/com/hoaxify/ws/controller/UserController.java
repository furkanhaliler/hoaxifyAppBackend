package com.hoaxify.ws.controller;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.dto.UserWithPageDto;
import com.hoaxify.ws.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @PostMapping("/save")
  public Result<UserDto> save(@RequestBody @Valid UserRequest userRequest) {

    return userService.save(userRequest);
  }

  @GetMapping("/getAll")
  public Result<List<UserDto>> getUsers(){
    return userService.getAll();
  }

  @GetMapping("/getAllPaged")
  public Result<UserWithPageDto> getUsersPaged(Pageable page){
    return userService.getAllPaged(page);
  }
}
