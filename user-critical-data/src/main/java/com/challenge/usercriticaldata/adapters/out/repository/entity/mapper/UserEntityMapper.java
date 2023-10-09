package com.challenge.usercriticaldata.adapters.out.repository.entity.mapper;

import com.challenge.usercriticaldata.adapters.out.repository.entity.UserEntity;
import com.challenge.usercriticaldata.application.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {


    User toUser(UserEntity userEntity);
}
