package com.examplespringbootproject.BookMyShow.DTO;

import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Builder
public class TicketDto {
    long id;

    String allocated_seat;

    double amount;

    Date bookedAt;

    UserEntity userEntity;

    ShowEntity showEntity;
}
/*
Set<String> requestedSeats; //User will give

    int id; //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

    SeatTypes seatType; //TheaterSeatEntity
 */