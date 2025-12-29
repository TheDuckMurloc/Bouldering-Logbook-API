package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "StyleTag")
public class StyleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TagID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy = "styleTags")
    private List<Climb> climbs;

    public StyleTag() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Climb> getClimbs() { return climbs; }
    public void setClimbs(List<Climb> climbs) { this.climbs = climbs; }
}

