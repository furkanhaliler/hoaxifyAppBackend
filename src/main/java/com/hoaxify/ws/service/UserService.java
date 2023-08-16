package com.hoaxify.ws.service;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.dto.UserRequest;
import com.hoaxify.ws.model.dto.UserWithPageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Result<UserDto> save(UserRequest userRequest);

    Result<List<UserDto>> getAll();

    Result<UserWithPageDto> getAllPaged(Pageable page);
}
