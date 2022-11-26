package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ShowDto;
import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import lombok.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static ShowEntity convertDtoToShowEntity(ShowEntryDto showEntryDto){
        return ShowEntity.builder().show_date(showEntryDto.getShowDate()).show_time(showEntryDto.getShowTime()).build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto) {
        return ShowResponseDto.builder().id(showEntity.getId()).showTime(showEntity.getShow_time())
                .showDate(showEntity.getShow_date())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theatreResponseDto(showEntryDto.getTheatreResponseDto())
                .build();
    }
    public static ShowResponseDto convertShowEntityToDto(ShowEntity showEntity){
        return ShowResponseDto.builder().id(showEntity.getId()).showDate(showEntity.getShow_date())
                .showTime(showEntity.getShow_time())
                .build();
    }
}
/*

   int id;

    LocalDate showDate;

    LocalTime showTime;

    MovieResponseDto movieResponseDto;

    TheatreResponseDto theatreResponseDto;
 */
