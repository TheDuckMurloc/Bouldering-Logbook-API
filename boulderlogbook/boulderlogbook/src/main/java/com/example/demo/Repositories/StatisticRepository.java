package com.example.demo.Repositories;

import com.example.demo.Models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
    List<Statistic> findByUserID(int userID);
}
