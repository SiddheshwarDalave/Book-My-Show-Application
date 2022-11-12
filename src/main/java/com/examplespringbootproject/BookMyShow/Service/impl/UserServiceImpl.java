package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.UserConverter;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import com.examplespringbootproject.BookMyShow.Repository.UserRepository;
import com.examplespringbootproject.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUsers(UserDto userDto) {
        //i need to have UserEntity Object

        //create a method that converts userDto to userEntity
        UserEntity userEntity= UserConverter.convertDtoToUserEntity(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(int id) {
        Optional<UserEntity> userEntity=userRepository.findById(id);
        UserDto userDto=UserConverter.convertEntityToDto(userEntity);
        return userDto;
        //since i  need to return the userdto i have to convert entity to dto

    }
}
