package com.example.demo.Models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationID;

    @Column(nullable = false, length = 100)
    private String name;

    private String type;
    private String region;
    private String address;
    private String mapURL;

    @OneToMany(mappedBy = "location")
    private List<Climb> climbs;

    @OneToMany(mappedBy = "location")
    private List<Session> sessions;

}
