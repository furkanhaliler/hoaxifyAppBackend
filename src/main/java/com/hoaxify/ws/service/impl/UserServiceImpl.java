package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void save(UserRequest userRequest) {

    User user =
        new User()
            .userName(userRequest.userName())
            .displayName(userRequest.displayName())
            .password(passwordEncoder.encode(userRequest.password()));
    userRepository.save(user);
  }
}
