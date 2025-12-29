package com.example.demo.Services;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.Models.User;
import com.example.demo.Models.UserClimb;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.UserClimbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserClimbRepository userClimbRepository;

    // Bestaande methodes
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    // Nieuwe methodes voor UserClimb
    public List<UserClimb> getUserClimbs(int userId) {
        return userClimbRepository.findByUser_UserID(userId);
    }
    public Optional<UserDTO> getUserDtoById(int userId) {
    return userRepository.findById(userId)
            .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getProfilePhoto(), user.getJoinDate()));
}

}
