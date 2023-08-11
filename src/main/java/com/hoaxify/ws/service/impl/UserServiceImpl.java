package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.core.results.SuccessResult;
import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Result<UserDto> save(UserRequest userRequest) {

    User user =
        new User()
            .username(userRequest.username())
            .displayName(userRequest.displayName())
            .password(passwordEncoder.encode(userRequest.password()));
    userRepository.save(user);

    return new SuccessResult<>(HttpStatus.CREATED, "User created.",
            new UserDto(user.username(), user.displayName(), null));
  }

  @Override
  public Result<List<UserDto>> getAll() {
    List<User> users = userRepository.findAll();
    List<UserDto> userDtoList = users.stream().map(user -> new UserDto(user.username(),
            user.displayName(), null)).toList();
    return new SuccessResult<>(HttpStatus.OK, "Users fetched.", userDtoList);
  }
}
