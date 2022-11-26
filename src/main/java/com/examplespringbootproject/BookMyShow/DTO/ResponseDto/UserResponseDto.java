package com.examplespringbootproject.BookMyShow.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserResponseDto {
    private int id;

    private String name;

    private String mobile;
}
