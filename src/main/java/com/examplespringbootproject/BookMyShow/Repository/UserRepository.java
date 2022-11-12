package com.examplespringbootproject.BookMyShow.Repository;

import com.examplespringbootproject.BookMyShow.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
