package com.examplespringbootproject.BookMyShow.DTO;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    int id;
    @NotNull
    String name;
    @NotNull
    String mobileNo;
}
