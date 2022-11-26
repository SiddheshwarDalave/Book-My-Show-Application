package com.examplespringbootproject.BookMyShow.DTO;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
