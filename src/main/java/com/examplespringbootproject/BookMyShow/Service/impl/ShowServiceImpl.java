package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.ShowConverter;
import com.examplespringbootproject.BookMyShow.DTO.ShowDto;
import com.examplespringbootproject.BookMyShow.Model.*;
import com.examplespringbootproject.BookMyShow.Repository.MovieRepository;
import com.examplespringbootproject.BookMyShow.Repository.ShowRepository;
import com.examplespringbootproject.BookMyShow.Repository.ShowSeatRepository;
import com.examplespringbootproject.BookMyShow.Repository.TheatreRepository;
import com.examplespringbootproject.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {
        ShowEntity showEntity= ShowConverter.convertDtoToShowEntity(showDto);
        //this is partial data// need  to add moviedto and theatredto
        MovieEntity movieEntity= movieRepository.findById(showDto.getMovieDto().getId()).get();
        TheatreEntity theatreEntity=theatreRepository.findById(showDto.getTheatreDto().getId()).get();
        //setting value
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);

        //method to creating seats for shows same as theatre have

        generateVirtualSeatsForShow(theatreEntity.getListOfTheatreSeat(),showEntity);

        showEntity=showRepository.save(showEntity);

        return showDto;

    }
    public void generateVirtualSeatsForShow(List<TheatreSeatEntity> listOfTheatreSeat,ShowEntity showEntity){
        //creating list for show
        List<ShowSeatEntity> listOfSeatsForShowEntity=new ArrayList<>();

        //copying listOfTheatreSeat to listOfSeatsForShowEntity

        for(TheatreSeatEntity theatreSeatEntity: listOfTheatreSeat){
            ShowSeatEntity showSeatEntity=ShowSeatEntity.builder().seat_no(theatreSeatEntity.getSeat_no()).rate(theatreSeatEntity.getRate()).seat_type(theatreSeatEntity.getSeat_type()).showEntity(showEntity).build();

            listOfSeatsForShowEntity.add(showSeatEntity);
        }
        //if you want add seperatelly showEntity with with show
//        for(ShowSeatEntity showSeatEntity: listOfSeatsForShowEntity){
//            showSeatEntity.setShowEntity(showEntity);
//        }

        showSeatRepository.saveAll(listOfSeatsForShowEntity);
    }

    @Override
    public ShowDto getShowById(int id) {
        //need to complete
        return null;
    }
}
