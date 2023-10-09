package com.challenge.usercriticaldata.adapters.in.controller.mapper;

import com.challenge.usercriticaldata.adapters.in.controller.request.UserRequest;
import com.challenge.usercriticaldata.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequest toUserRequest(User user);

}
