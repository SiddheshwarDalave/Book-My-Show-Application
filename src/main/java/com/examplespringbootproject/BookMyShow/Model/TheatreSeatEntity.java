package com.examplespringbootproject.BookMyShow.Model;

import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
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
@Table(name="TheatreSeat_data")
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_no",nullable = false)
    private String seat_no;

    @Column(name = "seat_no",nullable = false,insertable = false,updatable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Seat_type",nullable = false)
    private SeatTypes seat_type;

    //relation

    //TheatreEntity
//    @ManyToOne
//    @JsonIgnore
//    private TheatreSeatEntity theatreSeatEntity;

    @ManyToOne//(cascade = CascadeType.ALL)
    //@JoinColumn(name = "theatre_entity_id") // it was giving me error so added this //now commented back but works fine
    @JsonIgnore
    private TheatreEntity theatreEntity;

//done
}
