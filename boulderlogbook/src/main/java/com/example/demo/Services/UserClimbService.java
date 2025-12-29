package com.example.demo.Services;

import com.example.demo.Models.Climb;
import com.example.demo.Models.User;
import com.example.demo.Models.UserClimb;
import com.example.demo.Models.UserClimbId;
import com.example.demo.Repositories.ClimbRepository;
import com.example.demo.Repositories.UserClimbRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserClimbService {

    private final UserClimbRepository userClimbRepository;
    private final UserRepository userRepository;
    private final ClimbRepository climbRepository;

    public UserClimbService(UserClimbRepository userClimbRepository,
                            UserRepository userRepository,
                            ClimbRepository climbRepository) {
        this.userClimbRepository = userClimbRepository;
        this.userRepository = userRepository;
        this.climbRepository = climbRepository;
    }

    public UserClimb logBoulder(
            int userId,
            int climbId,
            Integer attempts,
            String notes,
            String ascentType
    ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Climb climb = climbRepository.findById(climbId)
                .orElseThrow(() -> new RuntimeException("Climb not found"));

        Optional<UserClimb> existing = userClimbRepository.findById(
                new UserClimbId(userId, climbId)
        );

        if (existing.isPresent()) {
            UserClimb uc = existing.get();
            uc.setAttempts(attempts);
            uc.setNotes(notes);
            uc.setLoggedAt(LocalDate.now());
            uc.setAscentType(ascentType);
            return userClimbRepository.save(uc);
        }

        UserClimb userClimb =
                new UserClimb(user, climb, LocalDate.now(), attempts, notes, ascentType);

        userClimb.setLoggedAt(LocalDate.now());
        userClimb.setAscentType(ascentType);

        return userClimbRepository.save(userClimb);
    }

    public List<UserClimb> getUserClimbsByUserId(int userId) {
        return userClimbRepository.findByUser_UserID(userId);
    }
}


