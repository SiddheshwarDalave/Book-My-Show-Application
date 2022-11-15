package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.MovieConverter;
import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import com.examplespringbootproject.BookMyShow.Repository.MovieRepository;
import com.examplespringbootproject.BookMyShow.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
//or logger library
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public MovieDto addMovie(MovieDto movieDto) { //dto to entity
        
        if(movieDto.getId()<0){ //if id less
            throw new EntityNotFoundException("Movie could not found");
        }

        log.info("adding the movie",movieDto);

        MovieEntity movieEntity= MovieConverter.convertDtoToMovieEntity(movieDto);
        movieRepository.save(movieEntity);
        return movieDto;
    }

    @Override
    public MovieDto getMovie(int id) { //entity to dto
        MovieEntity movieEntity=movieRepository.findById(id).get();

        MovieDto movieDto=MovieConverter.convertMovieEntityTODto(movieEntity);

        return movieDto;
    }
}
