package com.examplespringbootproject.BookMyShow.Service;


import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;

public interface UserService {
    void addUsers(UserDto userDto);
    UserDto getUser(int id);
}
