package com.example.demo.DTOs;

public class LocationDTO {

    private int id;
    private String name;
    private String region;
    private String address;

    public LocationDTO(int id, String name, String region, String address) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getAddress() {
        return address;
    }
}
