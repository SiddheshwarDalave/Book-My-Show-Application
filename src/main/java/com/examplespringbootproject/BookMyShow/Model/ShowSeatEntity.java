package com.examplespringbootproject.BookMyShow.Model;

import com.examplespringbootproject.BookMyShow.Enums.SeatTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.Join;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "Allocated_seat")
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_no")
    private String seat_no;

    @Column (name = "rate")
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_types")
    private SeatTypes seat_type;

    @Column(name = "is_booked")
    private boolean isBooked;
    //time stamp
    //@CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookedAt;


    //relation

    //pending part

    //TicketEntity-is parent and showSeat is child
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TicketEntity ticketEntity;

    //ShowEntity- is the parent
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity showEntity1;


//done
}
