package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;
import com.examplespringbootproject.BookMyShow.Model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity convertDtoToTheatreEntity(TheatreEntryDto theatreEntryDto){
        return TheatreEntity.builder().name(theatreEntryDto.getName()).address(theatreEntryDto.getAddress()).city(theatreEntryDto.getCity()).type(theatreEntryDto.getType()).build();
    }
    //Should we write theatreDto.showDto()??? -->

    public static TheatreResponseDto convertTheatreEntityToDto(TheatreEntity theatreEntity){
        return TheatreResponseDto.builder().id(theatreEntity.getId()).name(theatreEntity.getName()).address(theatreEntity.getAddress()).city(theatreEntity.getCity()).type(theatreEntity.getType()).build();
    }
}
