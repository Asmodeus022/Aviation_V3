package com.barcode.aviation.tool.inventory.mapper;

import com.barcode.aviation.tool.inventory.dto.UserDto;
import com.barcode.aviation.tool.inventory.entities.UserEntity;

public class UserMapper {
    public static UserDto maptoUserDto(UserEntity userEntity){
        return new UserDto(
            userEntity.getId(),
            userEntity.getUsername(),
            userEntity.getFullname(),
            userEntity.getPassword(),
            userEntity.getRole()
        );
    }   
    
    public static UserEntity maptoUser(UserDto userDto){
        return new UserEntity(
            userDto.getId(),
            userDto.getUsername(),
            userDto.getFullname(),
            userDto.getPassword(),
            userDto.getRole()
        );
    }
}
