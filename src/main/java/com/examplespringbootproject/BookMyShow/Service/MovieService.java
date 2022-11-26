package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface MovieService {
    MovieEntryDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id);
}
