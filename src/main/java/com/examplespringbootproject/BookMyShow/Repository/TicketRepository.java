package com.examplespringbootproject.BookMyShow.Repository;

import com.examplespringbootproject.BookMyShow.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
