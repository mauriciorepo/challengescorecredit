package com.challenge.creditscore.adapters.out.client.mapper;

import com.challenge.creditscore.adapters.out.client.response.UserResponse;
import com.challenge.creditscore.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    User toUser(UserResponse userResponse);
}
