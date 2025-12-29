package com.example.demo.Repositories;

import com.example.demo.Models.UserClimb;
import com.example.demo.Models.UserClimbId;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserClimbRepository extends JpaRepository<UserClimb, UserClimbId> {

    List<UserClimb> findByUser_UserID(int userId);
    
    
}
