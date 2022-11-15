package com.examplespringbootproject.BookMyShow.DTO;

import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import com.examplespringbootproject.BookMyShow.Model.TheatreEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowDto {
    int id;

    LocalDate showDate;

    LocalTime showTime;

    MovieDto movieDto;

    TheatreDto theatreDto;
}
