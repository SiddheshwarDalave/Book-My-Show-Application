package com.examplespringbootproject.BookMyShow.DTO.ResponseDto;

import com.examplespringbootproject.BookMyShow.Enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {

    int id;
    String name;
    String address;
    String city;
    TheatreType type;
}
