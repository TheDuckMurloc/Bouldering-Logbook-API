package com.example.demo.Models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserClimbId implements Serializable {

    private int userId;
    private int climbId;

    public UserClimbId() {}

    public UserClimbId(int userId, int climbId) {
        this.userId = userId;
        this.climbId = climbId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserClimbId that = (UserClimbId) o;
        return userId == that.userId && climbId == that.climbId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, climbId);
    }

    // getters & setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getClimbId() { return climbId; }
    public void setClimbId(int climbId) { this.climbId = climbId; }
}

