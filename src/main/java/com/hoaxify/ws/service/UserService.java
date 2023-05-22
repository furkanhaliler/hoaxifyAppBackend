package com.hoaxify.ws.service;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;

public interface UserService {
    Result<UserDto> save(UserRequest userRequest);
}
