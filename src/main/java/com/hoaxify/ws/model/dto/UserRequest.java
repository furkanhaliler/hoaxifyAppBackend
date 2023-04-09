package com.hoaxify.ws.model.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserRequest(
        @NotEmpty(message = "User name can not be null or empty.") String userName,
        @NotEmpty(message = "Display name can not be null or empty.") String displayName,
        @NotEmpty(message = "Password can not be null or empty.") String password) {
}
