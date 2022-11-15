package com.examplespringbootproject.BookMyShow.Repository;

import com.examplespringbootproject.BookMyShow.Model.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
