package com.example.demo.Controllers;

import com.example.demo.DTOs.ClimbDTO;
import com.example.demo.Models.Climb;
import com.example.demo.Services.ClimbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://bouldering-logbook-user-frontend.onrender.com")
@RestController
@RequestMapping("/api/climbs")
public class ClimbController {

    private final ClimbService climbService;

    @Autowired
    public ClimbController(ClimbService climbService) {
        this.climbService = climbService;
    }

    @GetMapping
    public List<ClimbDTO> getAllClimbs() {
        return climbService.getAllClimbs();
    }

    @GetMapping("/{id}")
    public ClimbDTO getClimbById(@PathVariable int id) {
        return climbService.getClimbById(id);
    }

    @PostMapping
    public ClimbDTO createClimb(@RequestBody ClimbDTO climbDTO) {
        return climbService.createClimb(climbDTO);
    }

    @GetMapping("/user/{userId}")
    public List<ClimbDTO> getClimbsByUser(@PathVariable int userId) {
        return climbService.getClimbsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteClimb(@PathVariable int id) {
        climbService.deleteClimb(id);
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Climb>> getClimbsByLocation(
            @PathVariable int locationId
    ) {
        return ResponseEntity.ok(climbService.getClimbsByLocationId(locationId));
    }
}
