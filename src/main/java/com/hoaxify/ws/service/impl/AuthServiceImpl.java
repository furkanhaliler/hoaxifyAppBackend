package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.core.results.ErrorResult;
import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.core.results.SuccessResult;
import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.dto.UserDto;
import com.hoaxify.ws.model.entity.User;
import com.hoaxify.ws.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Result<?> handleAuthentication(String authorization) {
        String base64Encoded = authorization.split("Basic ")[1];
        String base64Decoded = new String(Base64.getDecoder().decode(base64Encoded));
        if (base64Decoded.length() < 3) {
            return new ErrorResult<>(HttpStatus.UNAUTHORIZED, "Unauthorized request.", "/auth/");
        }
        String[] parts = base64Decoded.split(":");
        String userName = parts[0];
        User user = userRepository.findByUserName(userName);
        return new SuccessResult<>(HttpStatus.OK, "Successful authorization.", new UserDto(user.userName(), user.displayName()));
    }
}
