package com.examplespringbootproject.BookMyShow.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreDto {
    int id;

    String name;

    String address;

    String city;
    //theatre seat-> dont need to pass //declare in theatre service impl

    //showEntity
    List<ShowDto> showDtoList;
}
