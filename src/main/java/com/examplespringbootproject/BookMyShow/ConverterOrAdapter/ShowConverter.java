package com.examplespringbootproject.BookMyShow.ConverterOrAdapter;

import com.examplespringbootproject.BookMyShow.DTO.ShowDto;
import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import lombok.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static ShowEntity convertDtoToShowEntity(ShowDto showDto){
        return ShowEntity.builder().show_date(showDto.getShowDate()).show_time(showDto.getShowTime()).build();
    }
}

