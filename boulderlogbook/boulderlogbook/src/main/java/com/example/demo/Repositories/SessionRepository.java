package com.example.demo.Repositories;

import com.example.demo.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    List<Session> findByUserID(int userID);
    List<Session> findByLocationID(int locationID);
}
