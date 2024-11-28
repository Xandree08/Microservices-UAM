package com.projecta3.userservices.repository;

import com.projecta3.userservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public void deleteUserById(Long userId);
    public User findUserById(Long userId);
    public User findUserByEmail(String email);
    public User findUserByRa(String ra);
}
