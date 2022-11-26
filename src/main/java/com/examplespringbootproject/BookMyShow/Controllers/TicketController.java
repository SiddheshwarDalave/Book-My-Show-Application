package com.examplespringbootproject.BookMyShow.Controllers;

import com.examplespringbootproject.BookMyShow.DTO.BookTicketRequestDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TicketDto;
import com.examplespringbootproject.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/add")
        public ResponseEntity<TicketResponseDto> addTicket(@RequestBody BookTicketRequestDto ticketDto){
            return new ResponseEntity<TicketResponseDto>(ticketService.addTicket(ticketDto), HttpStatus.OK);
        }

}
