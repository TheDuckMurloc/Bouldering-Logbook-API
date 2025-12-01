package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    private String description;
    private String targetGrade;

    @Temporal(TemporalType.DATE)
    private Date deadline;

    private float progress;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    private boolean completed;

    // getters en setters
}
