package com.examplespringbootproject.BookMyShow.Controllers;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.examplespringbootproject.BookMyShow.Repository.MovieRepository;
import com.examplespringbootproject.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<MovieEntryDto> addMovie(@RequestBody MovieEntryDto movieEntryDto){
        return new ResponseEntity<>(movieService.addMovie(movieEntryDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<MovieResponseDto> getMovie(@PathVariable int id){
        return new ResponseEntity<MovieResponseDto>(movieService.getMovie(id),HttpStatus.OK);
    }
}
