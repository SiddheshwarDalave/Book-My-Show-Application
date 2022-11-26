package com.examplespringbootproject.BookMyShow.Controllers;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.UserEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.examplespringbootproject.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserEntryDto> addUser(@RequestBody UserEntryDto userEntryDto){

        return new ResponseEntity<UserEntryDto>(userService.addUsers(userEntryDto),HttpStatus.CREATED);
    }
    @GetMapping("get-user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id ){
        return new ResponseEntity<UserResponseDto>(userService.getUser(id),HttpStatus.OK);
    }

}
