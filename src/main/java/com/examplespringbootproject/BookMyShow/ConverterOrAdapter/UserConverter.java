package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass //means it has static method and does not have object //common classes //only method call
public class UserConverter {
    public static UserEntity convertDtoToUserEntity(UserDto userDto){
        return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobileNo()).build();
    }
    public static UserDto convertEntityToDto(Optional<UserEntity> userEntity){
        return UserDto.builder().id(userEntity.get().getId()).name(userEntity.get().getName()).mobileNo(userEntity.get().getMobile()).build();
    }
}
