package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.DTO.UserDto;
import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static MovieEntity convertDtoToMovieEntity(MovieDto movieDto){ //dto to entity
        return MovieEntity.builder().id(movieDto.getId()).name(movieDto.getName()).showDate(movieDto.getShowDate()).listOfShowEntity(movieDto.getListOfShowEntity()).build();
    }

    public static MovieDto convertMovieEntityTODto(MovieEntity movieEntity){ //entity to dto
        return MovieDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).showDate(movieEntity.getShowDate()).listOfShowEntity(movieEntity.getListOfShowEntity()).build();

    }
}
