package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static MovieEntity convertDtoToMovieEntity(MovieEntryDto movieEntryDto){ //dto to entity
        return MovieEntity.builder().name(movieEntryDto.getName()).showDate(movieEntryDto.getShowDate()).build();
    }
//listOfShowEntity(movieDto.getListOfShowEntity())
    public static MovieResponseDto convertMovieEntityTODto(MovieEntity movieEntity){ //entity to dto
        return MovieResponseDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).showDate(movieEntity.getShowDate()).listOfShowEntity(movieEntity.getListOfShowEntity()).build();

    }
}
