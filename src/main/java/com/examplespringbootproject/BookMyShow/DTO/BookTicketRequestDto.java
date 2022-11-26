package com.examplespringbootproject.BookMyShow.DTO;

import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
import lombok.*;

import java.util.List;
import java.util.Set;
@Data //getter setter and all arg and no arg
@Builder
public class BookTicketRequestDto {
    Set<String> requestedSeats; //User will give

    int id; //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

   SeatTypes seatType; //TheaterSeatEntity
}
