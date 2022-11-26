package com.examplespringbootproject.BookMyShow.Controllers;

import com.examplespringbootproject.BookMyShow.DTO.EntryDto.TheatreEntryDto;
import com.examplespringbootproject.BookMyShow.DTO.ResponseDto.TheatreResponseDto;
import com.examplespringbootproject.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("add-theatre")
    public ResponseEntity<TheatreEntryDto> addTheatre(@RequestBody TheatreEntryDto theatreEntryDto){
        return new ResponseEntity<TheatreEntryDto>(theatreService.addTheatre(theatreEntryDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-theatre/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatre(@PathVariable int id){
        return new ResponseEntity<TheatreResponseDto>(theatreService.getTheatre(id),HttpStatus.OK);
    }
}
