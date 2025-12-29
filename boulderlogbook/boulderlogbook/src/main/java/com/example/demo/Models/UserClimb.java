package com.example.demo.Models;
import jakarta.persistence.*;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

@Entity
@Table(name = "UserClimb")
public class UserClimb {

    @EmbeddedId
    private UserClimbId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @MapsId("climbId")
    @JoinColumn(name = "ClimbID")
    private Climb climb;


    private Integer attempts;

    @Column(length = 1000)
    private String notes;

    private LocalDate loggedAt;

    private String AscentType;

    public UserClimb() {}

    public UserClimb(User user, Climb climb, LocalDate loggedAt, Integer attempts, String notes, String AscentType) {
        this.id = new UserClimbId(user.getId(), climb.getId());
        this.user = user;
        this.climb = climb;
        this.loggedAt = LocalDate.now();
        this.attempts = attempts;
        this.AscentType = AscentType;
        this.notes = notes;
    }

    public UserClimbId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Climb getClimb() {
        return climb;
    }
    
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setLoggedAt(LocalDate loggedAt) {
        this.loggedAt = loggedAt;
    }

    public LocalDate getLoggedAt() {
    return loggedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAscentType() {
        return AscentType;
    }

    public void setAscentType(String ascentType) {
        AscentType = ascentType;
    }
}
