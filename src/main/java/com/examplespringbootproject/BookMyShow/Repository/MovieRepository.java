package com.examplespringbootproject.BookMyShow.Repository;

import com.examplespringbootproject.BookMyShow.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}
