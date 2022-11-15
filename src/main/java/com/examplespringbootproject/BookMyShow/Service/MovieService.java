package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.MovieDto;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);

    MovieDto getMovie(int id);
}
