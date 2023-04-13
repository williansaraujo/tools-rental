package com.willianaraujo.toolsrental.mapper;

import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);


}
