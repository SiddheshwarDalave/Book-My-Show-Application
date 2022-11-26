package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;
import org.springframework.stereotype.Service;

@Service
public interface TheatreService {

    TheatreEntryDto addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatre(int id);
}
