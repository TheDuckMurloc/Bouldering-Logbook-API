package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "style_tags")
public class StyleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagID;

    @Column(nullable = false, length = 50)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "styleTags")
    private List<Climb> climbs;

}
