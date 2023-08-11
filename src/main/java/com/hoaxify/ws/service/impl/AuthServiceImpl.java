package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.core.results.SuccessResult;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Result<?> handleAuthentication(User user) {
        return new SuccessResult<>(HttpStatus.OK, "Successful authorization.", new UserDto(user.username(), user.displayName(), null));
    }
}
