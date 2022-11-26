package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.UserConverter;
import com.examplespringbootproject.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import com.examplespringbootproject.BookMyShow.Repository.UserRepository;
import com.examplespringbootproject.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component //added later
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntryDto addUsers(UserEntryDto userEntryDto) {
        //i need to have UserEntity Object

        //create a method that converts userDto to userEntity
        UserEntity userEntity= UserConverter.convertDtoToUserEntity(userEntryDto);
        userRepository.save(userEntity);
        return userEntryDto;
    }

    @Override
    public UserResponseDto getUser(int id) {
        //since i  need to return the userdto i have to convert entity to dto

//        Optional<UserEntity> userEntity=userRepository.findById(id);
//        UserDto userDto=UserConverter.convertEntityToDto(userEntity);

        //if i don't want to use optional then>>
        UserEntity userEntity=userRepository.findById(id).get();//orElse(null or by default);// get retun null if object does not found anything
        UserResponseDto userResponseDto=UserConverter.convertEntityToDto(userEntity);
        return userResponseDto;

        //or
//        Optional<UserEntity> userEntity=userRepository.findById(id);//orElse(null or by default);// get retun null if object does not found anything
//        UserDto userDto=UserConverter.convertEntityToDto(userEntity.get());
//        return userDto; //no need to change anything in convertor 2


    }
}
