package com.examplespringbootproject.BookMyShow.DTO.ResponseDto;

import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder

public class MovieResponseDto {
    int id;

    String name;

    LocalDate showDate;

    List<ShowEntity> listOfShowEntity;
}
