package com.examplespringbootproject.BookMyShow.Service;

import com.examplespringbootproject.BookMyShow.DTO.ShowDto;

public interface ShowService {
    ShowDto  addShow(ShowDto showDto);

    ShowDto getShowById(int id);
}
