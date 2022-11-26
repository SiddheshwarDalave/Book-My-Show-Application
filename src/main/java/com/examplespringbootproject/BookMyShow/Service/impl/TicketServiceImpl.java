package com.examplespringbootproject.BookMyShow.Service.impl;

import com.examplespringbootproject.BookMyShow.ConverterOrAdapter.TicketConverter;
import com.examplespringbootproject.BookMyShow.DTO.BookTicketRequestDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TicketDto;
import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import com.examplespringbootproject.BookMyShow.Model.ShowSeatEntity;
import com.examplespringbootproject.BookMyShow.Model.TicketEntity;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import com.examplespringbootproject.BookMyShow.Repository.ShowRepository;
import com.examplespringbootproject.BookMyShow.Repository.TicketRepository;
import com.examplespringbootproject.BookMyShow.Repository.UserRepository;
import com.examplespringbootproject.BookMyShow.Service.ShowService;
import com.examplespringbootproject.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;


    @Override
    public TicketDto getTicket(int id) { //HW
        return null;
    }

    @Override
    public TicketResponseDto addTicket(BookTicketRequestDto bookTicketRequestDto) {
       //get user and show entity for ticket

        UserEntity userEntity=userRepository.findById(bookTicketRequestDto.getId()).get();

        ShowEntity showEntity=showRepository.findById(bookTicketRequestDto.getShowId()).get();


//        Set<Set<String>> requestedSeats= new HashSet<>();
//                requestedSeats.add(bookTicketRequestDto.getRequestedSeats());
// allocated_seat
        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatEntity> showSeatEntityList=showEntity.getListOfShowSeatEntity();//list of showseat//complete

//        //option 1
        List<ShowSeatEntity> bookedSeats=showSeatEntityList
                .stream() // statnderd
                .filter(seat->seat.getSeat_type().equals(bookTicketRequestDto.getSeatType()) //filter like for loop
                 && !seat.isBooked()&& requestedSeats.contains(seat.getSeat_no()))
                .collect(Collectors.toList());


//        List<ShowSeatEntity> bookedSeats=new ArrayList<>();
//        for(ShowSeatEntity seat: showSeatEntityList){
//            if(!seat.isBooked() && seat.getSeat_type().equals(bookTicketRequestDto.getSeatType()) && requestedSeats.contains(seat.getSeat_no()));
//            bookedSeats.add(seat);
//        }
        //cond 1 seats availability
        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Error("All seats are not available");
        }
        //create ticket entity
        TicketEntity ticketEntity=TicketEntity.builder()
                .user(userEntity)
                .showEntity(showEntity)
                .listOfShowSeatEntity(bookedSeats).build();

        //step3 showseat entity
        //amount
        double amount=0;

        for(ShowSeatEntity showSeatEntity: bookedSeats){
            showSeatEntity.setBooked(true);
            showSeatEntity.setBookedAt(new Date());
            showSeatEntity.setTicketEntity(ticketEntity);
            amount=amount+showSeatEntity.getRate();
        }
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllocated_seat(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);

        //step 4 connect in the show
        //showentity.setTicket//later
        //userEentity.setTicket later
        showEntity.getListOfTicketEntity().add(ticketEntity);
        userEntity.getListOfTicketEntity().add(ticketEntity);

        ticketEntity=ticketRepository.save(ticketEntity);

        TicketResponseDto ticketResponseDto= TicketConverter.convertTicketEntityToDto(ticketEntity);
        return  ticketResponseDto;
    }
    public String convertListOfSeatsEntityToString(List<ShowSeatEntity> bookedSeats){

        String str = "";
        for(ShowSeatEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeat_no()+" ";
        }

        return str;

    }
}
