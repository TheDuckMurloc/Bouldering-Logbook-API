package com.example.demo.Controllers;

import com.example.demo.Models.UserClimb;
import com.example.demo.Services.UserClimbService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-climbs")
@CrossOrigin(origins = "https://bouldering-logbook-user-frontend.onrender.com")
public class UserClimbController {

    private final UserClimbService userClimbService;

    public UserClimbController(UserClimbService userClimbService) {
        this.userClimbService = userClimbService;
    }

    @PostMapping("/log")
    public ResponseEntity<UserClimb> logBoulder(
            Authentication authentication,
            @RequestParam("climbId") int climbId,
            @RequestParam(value = "attempts", required = false) Integer attempts,
            @RequestParam(value = "notes", required = false) String notes,
            @RequestParam(value = "AscentType", required = false) String AscentType
    ) {
        try {
            int userId = (int) authentication.getPrincipal();

            UserClimb userClimb =
                userClimbService.logBoulder(
                    userId,
                    climbId,
                    attempts,
                    notes,
                    AscentType
                );

            return ResponseEntity.ok(userClimb);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserClimb>> findByUser_UserID(
            Authentication authentication
    ) {
        int userId = (int) authentication.getPrincipal();

        List<UserClimb> climbs =
            userClimbService.getUserClimbsByUserId(userId);

        return ResponseEntity.ok(climbs);
    }
}
