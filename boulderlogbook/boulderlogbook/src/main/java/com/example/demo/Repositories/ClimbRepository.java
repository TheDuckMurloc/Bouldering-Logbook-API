package com.example.demo.Repositories;

import com.example.demo.Models.Climb;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClimbRepository extends JpaRepository<Climb, Integer> {
    List<Climb> findByUserID(int userID);
    List<Climb> findByLocationID(int locationID);
}
