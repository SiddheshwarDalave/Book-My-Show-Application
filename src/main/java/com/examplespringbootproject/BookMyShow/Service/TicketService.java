package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.BookTicketRequestDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TicketDto;

public interface TicketService {
    TicketDto getTicket(int id); //hw

    TicketResponseDto addTicket(BookTicketRequestDto bookTicketRequestDto);
}
