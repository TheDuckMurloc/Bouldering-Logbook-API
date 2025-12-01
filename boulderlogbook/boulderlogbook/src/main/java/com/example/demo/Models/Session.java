package com.example.demo.Models;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location location;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String notes;
    private int duration;

    @OneToMany
    private List<Climb> climbs;

    // getters en setters
}
