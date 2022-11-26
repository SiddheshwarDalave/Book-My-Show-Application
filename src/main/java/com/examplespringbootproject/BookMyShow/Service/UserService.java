package com.examplespringbootproject.BookMyShow.Service;


import com.examplespringbootproject.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component // added later
public interface UserService {
    public UserEntryDto addUsers (UserEntryDto userEntryDto);
    UserResponseDto getUser(int id);
}

