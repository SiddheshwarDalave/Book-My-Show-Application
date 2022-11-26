package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.MovieConverter;
import com.examplespringbootproject.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.MovieDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import com.examplespringbootproject.BookMyShow.Repository.MovieRepository;
import com.examplespringbootproject.BookMyShow.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Component
//or logger library
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public MovieEntryDto addMovie(MovieEntryDto movieEntryDto) { //dto to entity
        
//        if(movieDto.getId()<0){ //if id less
//            throw new EntityNotFoundException("Movie could not found");
//        }

        log.info("adding the movie",movieEntryDto);

        MovieEntity movieEntity= MovieConverter.convertDtoToMovieEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return movieEntryDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) { //entity to dto
        MovieEntity movieEntity=movieRepository.findById(id).get();

        MovieResponseDto    movieResponseDto=MovieConverter.convertMovieEntityTODto(movieEntity);

        return movieResponseDto;
    }
}
