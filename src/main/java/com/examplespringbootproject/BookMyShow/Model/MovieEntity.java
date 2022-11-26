package com.examplespringbootproject.BookMyShow.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

@Table(name = "Movie_data")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_date",columnDefinition = "DATE")
    private LocalDate showDate;

    //relation if any

    //List<ShowEntity>
    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShowEntity;
    //done
}
