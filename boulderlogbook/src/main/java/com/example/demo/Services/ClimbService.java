package com.example.demo.Services;

import com.example.demo.DTOs.ClimbDTO;
import com.example.demo.Models.Climb;
import com.example.demo.Models.UserClimb;
import com.example.demo.Repositories.ClimbRepository;
import com.example.demo.Repositories.UserClimbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimbService {

    private final ClimbRepository climbRepository;
    private final UserClimbRepository userClimbRepository;

    @Autowired
    public ClimbService(ClimbRepository climbRepository, UserClimbRepository userClimbRepository) {
        this.climbRepository = climbRepository;
        this.userClimbRepository = userClimbRepository;
    }

    // Haal alle climbs en map naar DTO
    public List<ClimbDTO> getAllClimbs() {
        return climbRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Haal climb op ID en map naar DTO
    public ClimbDTO getClimbById(int id) {
        return climbRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // Maak nieuwe climb aan
    public ClimbDTO createClimb(ClimbDTO climbDTO) {
        Climb climb = new Climb();
        climb.setGrade(climbDTO.getGrade());
        climb.setDate(climbDTO.getDate());
        climb.setPhoto(climbDTO.getPhoto());
        Climb saved = climbRepository.save(climb);
        return toDTO(saved);
    }

    // Haal alle climbs van een specifieke user
    public List<ClimbDTO> getClimbsByUser(int userId) {
        List<UserClimb> userClimbs = userClimbRepository.findByUser_UserID(userId);

        return userClimbs.stream()
                .map(UserClimb::getClimb)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Verwijder climb
    public void deleteClimb(int id) {
        climbRepository.deleteById(id);
    }

    // Helper method om entity naar DTO te mappen
    private ClimbDTO toDTO(Climb climb) {
        return new ClimbDTO(
                climb.getId(),
                climb.getGrade(),
                climb.getDate(),
                climb.getPhoto(),
                climb.getLocation() != null ? climb.getLocation().getName() : null
        );
    }

    public List<Climb> getClimbsByLocationId(int locationId) {
        return climbRepository.findByLocation_LocationID(locationId);
    }
    
}
