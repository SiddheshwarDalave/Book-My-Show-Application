package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.TheatreDto;
import com.examplespringbootproject.BookMyShow.Model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity convertDtoToTheatreEntity(TheatreDto theatreDto){
        return TheatreEntity.builder().id(theatreDto.getId()).name(theatreDto.getName()).address(theatreDto.getAddress()).city(theatreDto.getCity()).build();
    }
    //Should we write theatreDto.showDto()??? -->

    public static TheatreDto convertTheatreEntityToDto(TheatreEntity theatreEntity){
        return TheatreDto.builder().id(theatreEntity.getId()).name(theatreEntity.getName()).address(theatreEntity.getAddress()).city(theatreEntity.getCity()).build();
    }
}
