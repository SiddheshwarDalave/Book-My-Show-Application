package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.TheatreConverter;
import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;
import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
import com.examplespringbootproject.BookMyShow.Model.TheatreEntity;
import com.examplespringbootproject.BookMyShow.Model.TheatreSeatEntity;
import com.examplespringbootproject.BookMyShow.Repository.TheatreRepository;
import com.examplespringbootproject.BookMyShow.Repository.TheatreSeatsRepository;
import com.examplespringbootproject.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository; //creates seats here only
    @Override
    public TheatreDto addTheatre(TheatreDto theatreDto) {
        //create seat list
        TheatreEntity theatreEntity= TheatreConverter.convertDtoToTheatreEntity(theatreDto);

        //for seat
        List<TheatreSeatEntity> seats = createTheaterSeatsFunc();

        //set theatreId for each seat
        for(TheatreSeatEntity theatreSeatEntity1:seats){
            theatreSeatEntity1.setTheatreEntity(theatreEntity);
        }
        theatreRepository.save(theatreEntity);
        return theatreDto;
    }
    List<TheatreSeatEntity> createTheaterSeatsFunc(){

        List<TheatreSeatEntity> seats=new ArrayList<>();

        seats.add(getTheatreSeat("1A",100, SeatTypes.CLASSIC));
        seats.add(getTheatreSeat("1B",100, SeatTypes.CLASSIC));
        seats.add(getTheatreSeat("1C",100, SeatTypes.CLASSIC));
        seats.add(getTheatreSeat("1D",100, SeatTypes.CLASSIC));

        seats.add(getTheatreSeat("2A",100, SeatTypes.PREMIUM));
        seats.add(getTheatreSeat("2B",100, SeatTypes.PREMIUM));
        seats.add(getTheatreSeat("2C",100, SeatTypes.PREMIUM));
        seats.add(getTheatreSeat("2D",100, SeatTypes.PREMIUM));

        theatreSeatsRepository.saveAll(seats);
       return seats;
    }
    TheatreSeatEntity getTheatreSeat(String seatName,int rate,SeatTypes seatType){
        return TheatreSeatEntity.builder().seat_no(seatName).rate(rate).seat_type(seatType).build();
        //not->>// return TheatreSeatEntity.builder().seat_no(theatreSeatEntity.getSeat_no()).rate(theatreSeatEntity.getRate()).seat_type(theatreSeatEntity.getSeat_type()).build();
    }

    @Override
    public TheatreDto getTheatre(int id) {
        TheatreEntity theatreEntity=theatreRepository.findById(id).get();
        TheatreDto theatreDto=TheatreConverter.convertTheatreEntityToDto(theatreEntity);
        return theatreDto;
    }
}
