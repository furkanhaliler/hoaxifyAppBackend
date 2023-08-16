package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.core.results.SuccessResult;
import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.dto.UserWithPageDto;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

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

  @Override
  public Result<UserWithPageDto> getAllPaged(Pageable page) {
    Page<User> users = userRepository.findAll(page);
    List<UserDto> userDtoList = users.getContent().stream().map(user -> new UserDto(user.username(), user.displayName(), user.image())).toList();
    UserWithPageDto userWithPageDto = new UserWithPageDto(userDtoList, users.getTotalElements(), users.getTotalPages());
    return new SuccessResult<>(HttpStatus.OK, userDtoList.size() + " user fetched on page " + users.getNumber(), userWithPageDto);
  }
}
