package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.TicketDto;

public interface TicketService {
    TicketDto getTicket(int id);

    void addTicket(TicketDto ticketDto);
}
