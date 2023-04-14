package com.hoaxify.ws.model.dto;

import com.hoaxify.ws.constant.ValidationConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotEmpty(message = ValidationConstants.NULL_OR_EMPTY_MESSAGE)
        @Size(min = 3, max = 50, message = ValidationConstants.MIN_MAX_SIZE_MESSAGE)
        String userName,
        @NotEmpty(message = ValidationConstants.NULL_OR_EMPTY_MESSAGE)
        @Size(min = 3, max = 50, message = ValidationConstants.MIN_MAX_SIZE_MESSAGE)
        String displayName,
        @NotEmpty(message = ValidationConstants.NULL_OR_EMPTY_MESSAGE)
        @Size(min = 8, max = 50, message = ValidationConstants.MIN_MAX_SIZE_MESSAGE)
        @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
                message = ValidationConstants.PASSWORD_PATTERN_MESSAGE)
        String password) {
}
