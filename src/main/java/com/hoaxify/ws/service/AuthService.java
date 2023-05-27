package com.hoaxify.ws.service;

import com.hoaxify.ws.core.results.Result;
import com.hoaxify.ws.model.entity.User;

public interface AuthService {

    Result<?> handleAuthentication(User user);
}
