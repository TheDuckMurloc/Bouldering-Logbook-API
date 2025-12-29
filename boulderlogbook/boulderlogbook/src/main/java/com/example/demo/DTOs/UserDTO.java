package com.example.demo.DTOs;

import java.util.Date;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String profilePhoto;
    private Date joinDate;

    public UserDTO(int id, String name, String email, String profilePhoto, Date joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePhoto = profilePhoto;
        this.joinDate = joinDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getProfilePhoto() { return profilePhoto; }
    public Date getJoinDate() { return joinDate; }
}
