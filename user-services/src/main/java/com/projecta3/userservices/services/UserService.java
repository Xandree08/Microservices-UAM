package com.projecta3.userservices.services;

import com.projecta3.userservices.entities.User;
import com.projecta3.userservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserById(Long id) {
        if(id == null || id <= 0) return null;
        return userRepository.findById(id).get();
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
