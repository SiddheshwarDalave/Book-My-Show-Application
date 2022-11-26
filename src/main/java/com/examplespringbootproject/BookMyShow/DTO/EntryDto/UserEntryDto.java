package com.examplespringbootproject.BookMyShow.DTO.EntryDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntryDto {
    @NotNull
    private  String name;

    @NotNull
    private String mobile;
}
