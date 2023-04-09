package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.core.mapping.ModelMapperService;
import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private ModelMapperService modelMapperService;

  @Override
  public void save(UserRequest userRequest) {

    User user = modelMapperService.getMapper().map(userRequest, User.class);
    userRepository.save(user);
  }
}
