package com.example.demo.Models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    private String type;
    private String value;

    @Temporal(TemporalType.DATE)
    private Date calculatedDate;

}
