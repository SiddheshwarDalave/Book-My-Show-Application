package com.examplespringbootproject.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(value = {AuditingEntityListener.class})//not known till
@Table (name="Ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allocated_seats",nullable = false)
    private String allocated_seat;

    @Column(name = "Amount",nullable = false)
    private double amount;

//    @CreationTimestamp
//    private Date createdOn; //not like this
    //correct way below to get created timestamp
//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "booked_at", nullable = false)
//    private Date bookedAt;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "bookedAt",nullable = false)
    private Date bookedAt;

    //relationship
    //with user class
    //it is many(tickets) to one (user-parent)

    @ManyToOne //relation
    @JoinColumn //join table with user PK by default
    @JsonIgnore //avoid to pass as argument(this foreign key we could not pass or should not)
    private UserEntity user; //this is foreign key connect with user

    //with showEntity- relation as a child
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity showEntity;

    //List<ShowSeats> relation -> ticket is the parent
    @OneToMany(mappedBy = "showEntity1",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatEntity> listOfShowSeatEntity;
    //done
}
