package com.hoaxify.ws.model.dto;

import com.hoaxify.ws.constraint.UniqueUserName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotEmpty(message = "{hoaxify.validation.constraints.NotEmpty.message}")
        @Size(min = 3, max = 50, message = "{hoaxify.validation.constraints.Size.message}")
        @UniqueUserName
        String username,
        @NotEmpty(message = "{hoaxify.validation.constraints.NotEmpty.message}")
        @Size(min = 3, max = 50, message = "{hoaxify.validation.constraints.Size.message}")
        String displayName,
        @NotEmpty(message ="{hoaxify.validation.constraints.NotEmpty.message}")
        @Size(min = 8, max = 50, message = "{hoaxify.validation.constraints.Size.message}")
        @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
                message = "{hoaxify.validation.constraints.PasswordPattern.message}")
        String password) {
}
