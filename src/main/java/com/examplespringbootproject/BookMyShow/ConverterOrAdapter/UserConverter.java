package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass //means it has static method and does not have object //common classes //only method call
public class UserConverter {
    public static UserEntity convertDtoToUserEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobile()).build();
    }
    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobile(userEntity.getMobile()).build();
    }
}
