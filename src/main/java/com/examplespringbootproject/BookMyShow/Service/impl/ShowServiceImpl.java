package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.MovieConverter;
import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.ShowConverter;
import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.TheatreConverter;
import com.examplespringbootproject.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ShowDto;
import com.examplespringbootproject.BookMyShow.Model.*;
import com.examplespringbootproject.BookMyShow.Repository.MovieRepository;
import com.examplespringbootproject.BookMyShow.Repository.ShowRepository;
import com.examplespringbootproject.BookMyShow.Repository.ShowSeatRepository;
import com.examplespringbootproject.BookMyShow.Repository.TheatreRepository;
import com.examplespringbootproject.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
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
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity= ShowConverter.convertDtoToShowEntity(showEntryDto);
        //this is partial data// need  to add moviedto and theatredto
        MovieEntity movieEntity= movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        TheatreEntity theatreEntity=theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();
        //setting value
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);

        //method to creating seats for shows same as theatre have
        showEntity=showRepository.save(showEntity);

        generateVirtualSeatsForShow(theatreEntity.getListOfTheatreSeat(),showEntity);

        ShowResponseDto showResponseDto=ShowConverter.convertEntityToDto(showEntity,showEntryDto);


        return showResponseDto;

    }
    public void generateVirtualSeatsForShow(List<TheatreSeatEntity> listOfTheatreSeat,ShowEntity showEntity){
        //creating list for show
        List<ShowSeatEntity> listOfSeatsForShowEntity=new ArrayList<>();

        //copying listOfTheatreSeat to listOfSeatsForShowEntity

        for(TheatreSeatEntity theatreSeatEntity: listOfTheatreSeat){
            ShowSeatEntity showSeatEntity=ShowSeatEntity.builder()
                    .seat_no(theatreSeatEntity.getSeat_no())
                    .rate(theatreSeatEntity.getRate())
                    .seat_type(theatreSeatEntity.getSeat_type())
                    .showEntity1(showEntity).build();

            listOfSeatsForShowEntity.add(showSeatEntity);
        }
        //if you want add seperatelly showEntity with with show
//        for(ShowSeatEntity showSeatEntity: listOfSeatsForShowEntity){
//            showSeatEntity.setShowEntity(showEntity);
//        }
        for(ShowSeatEntity showSeatEntity: listOfSeatsForShowEntity){
            showSeatEntity.setShowEntity1(showEntity);
        }

        showSeatRepository.saveAll(listOfSeatsForShowEntity);

        showEntity.setListOfShowSeatEntity(listOfSeatsForShowEntity);
    }

    @Override
    public ShowResponseDto getShowById(int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        ShowResponseDto showResponseDto=ShowConverter.convertShowEntityToDto(showEntity);

        MovieEntity movieEntity =movieRepository.findById(id).get();
        TheatreEntity theatreEntity=theatreRepository.findById(id).get();

        MovieResponseDto movieResponseDto= MovieConverter.convertMovieEntityTODto(movieEntity);
        TheatreResponseDto theatreResponseDto= TheatreConverter.convertTheatreEntityToDto(theatreEntity);

        showResponseDto.setMovieResponseDto(movieResponseDto);
        showResponseDto.setTheatreResponseDto(theatreResponseDto);

        return showResponseDto;
    }
}
