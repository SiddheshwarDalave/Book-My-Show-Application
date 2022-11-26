package com.examplespringbootproject.BookMyShow.DTO.EntryDto;

import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    LocalDate showDate;

    LocalTime showTime;

    MovieResponseDto movieResponseDto;

    TheatreResponseDto theatreResponseDto;
}
