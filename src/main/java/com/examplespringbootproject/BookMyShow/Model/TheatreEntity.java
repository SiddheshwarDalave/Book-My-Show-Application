package com.examplespringbootproject.BookMyShow.Model;

import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
import com.examplespringbootproject.BookMyShow.Enums.TheatreType;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "Theatre_detail")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    TheatreType type;

    //relation
    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listOfShows;

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL) //getting error with "theatreEntity" //dont know why//added now by
    @JsonIgnore
    private List<TheatreSeatEntity> listOfTheatreSeat;

      //done


}
