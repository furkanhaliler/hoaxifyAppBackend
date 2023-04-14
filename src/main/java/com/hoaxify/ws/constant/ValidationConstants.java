package com.hoaxify.ws.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationConstants {

    public static final String MIN_MAX_SIZE_MESSAGE = "Size must be between {min} and {max} characters.";
    public static final String NULL_OR_EMPTY_MESSAGE = "Can not be null or empty.";
    public static final String PASSWORD_PATTERN_MESSAGE = "Password must have at least 1 uppercase, 1 lowercase character and 1 number.";
}
