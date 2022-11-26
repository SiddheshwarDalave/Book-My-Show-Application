package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TicketDto;
import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import com.examplespringbootproject.BookMyShow.Model.TicketEntity;
import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketResponseDto convertTicketEntityToDto(TicketEntity ticketEntity){
        return TicketResponseDto.builder().id(ticketEntity.getId()).allocated_seat(ticketEntity
                        .getAllocated_seat()).amount(ticketEntity.getAmount())
                .build();
    }
}
