package com.examplespringbootproject.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class})
@Builder
@ToString
@Entity
@Table(name = "Show_Data")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date",columnDefinition = "DATE",nullable = false)
    private LocalDate show_date;//private Date show_date;->previous // written what they used

    @Column(name = "show_time",columnDefinition = "TIME",nullable = false)
    private LocalTime show_time;

//created At
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

//updated At
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updateAt;

    //relation
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private MovieEntity movieEntity;
    //Theatre-parent
    @ManyToOne
    @JsonIgnore
    private TheatreEntity theatreEntity;

    //List<TicketEntity>->parent
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTicketEntity;

    //List<ShowSeatEntity>
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeatEntity;

    //pending
    ///done
}
