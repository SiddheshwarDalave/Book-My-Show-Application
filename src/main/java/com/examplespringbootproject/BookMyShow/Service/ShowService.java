package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.examplespringbootproject.BookMyShow.DTO.ShowDto;

public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    ShowResponseDto getShowById(int id);
}
