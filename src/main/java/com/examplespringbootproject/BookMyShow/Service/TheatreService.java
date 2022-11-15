package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;

public interface TheatreService {

    TheatreDto addTheatre(TheatreDto theatreDto);

    TheatreDto getTheatre(int id);
}
