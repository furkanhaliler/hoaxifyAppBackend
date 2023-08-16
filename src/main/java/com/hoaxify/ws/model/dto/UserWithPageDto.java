package com.hoaxify.ws.model.dto;

import java.util.List;

public record UserWithPageDto(List<UserDto> userList, Long totalUsers, Integer totalPages) {
}
