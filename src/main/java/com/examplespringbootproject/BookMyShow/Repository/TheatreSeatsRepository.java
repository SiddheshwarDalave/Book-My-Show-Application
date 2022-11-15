package com.examplespringbootproject.BookMyShow.Repository;

import com.examplespringbootproject.BookMyShow.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatsRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
