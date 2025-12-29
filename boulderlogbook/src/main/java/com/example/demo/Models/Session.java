package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SessionID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String notes;
    private int duration;

    @ManyToMany
    @JoinTable(
        name = "SessionClimb",
        joinColumns = @JoinColumn(name = "SessionID"),
        inverseJoinColumns = @JoinColumn(name = "ClimbID")
    )
    private List<Climb> climbs;

    // getters en setters
}
