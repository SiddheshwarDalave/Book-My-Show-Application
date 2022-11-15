package com.examplespringbootproject.BookMyShow.DTO;

import com.examplespringbootproject.BookMyShow.Model.ShowEntity;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    int id;
    @NotNull
    String name;

    LocalDate showDate;

    List<ShowEntity> listOfShowEntity;
}
