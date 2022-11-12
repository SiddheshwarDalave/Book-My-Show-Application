package com.examplespringbootproject.BookMyShow.Model;

import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
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
@ToString
@Entity
@Table(name = "Theatre_detail")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "address",nullable = false)
    private String address;


    //relation
    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listOfShows;

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL) //getting error with "theatreEntity" //dont know why//added now by
    @JsonIgnore
    private List<TheatreSeatEntity> listOfTheatreSeat;

      //done


}
