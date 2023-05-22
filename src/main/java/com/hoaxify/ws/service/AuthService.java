package com.hoaxify.ws.service;

import com.hoaxify.ws.core.results.Result;

public interface AuthService {

    Result<?> handleAuthentication(String authorization);
}
