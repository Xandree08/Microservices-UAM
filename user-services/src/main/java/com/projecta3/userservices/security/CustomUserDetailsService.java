package com.projecta3.userservices.security;

import com.projecta3.userservices.entities.User;
import com.projecta3.userservices.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.logging.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        User user = null;
        if (identifier.contains("@")) {
            try{
                user = userRepository.findUserByEmail(identifier);
                logger.info("User found with email: " + identifier);
            }catch (Exception e){
                logger.info(e.getMessage());
            }
        } else {
            try{
                user = userRepository.findUserByRa(identifier);
                logger.info("User found with ra: " + identifier);
            }catch (Exception e){
                logger.info(e.getMessage());
            }
        }

        assert user != null;
        return new LoginUserDTO(
                user.getRa(),
                user.getPassword(),
                true,
                Collections.emptyList()
        );
    }
}
