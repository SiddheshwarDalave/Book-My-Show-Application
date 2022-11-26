package com.examplespringbootproject.BookMyShow.Controllers;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.ShowEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.examplespringbootproject.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add-show")
    public ResponseEntity<ShowResponseDto> addShow(@RequestBody ShowEntryDto showEntryDto){
        return new ResponseEntity<ShowResponseDto>(showService.addShow(showEntryDto), HttpStatus.OK);
    }

    @GetMapping("/get-show/{id}")
    public ResponseEntity<ShowResponseDto> getShow(@PathVariable int id){
        return new ResponseEntity<ShowResponseDto>(showService.getShowById(id),HttpStatus.OK);
    }

}
