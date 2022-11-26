package com.examplespringbootproject.BookMyShow.DTO.EntryDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class MovieEntryDto {
    String name;

    LocalDate showDate;
}
