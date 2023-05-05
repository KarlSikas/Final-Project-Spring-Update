package com.example.finalprojectj19spring.services.implementations;

import com.example.finalprojectspring.exceptions.UserNotFoundException;
import com.example.finalprojectspring.models.User;
import com.example.finalprojectspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/29/2023
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.findUserByUsername(username);
            return new CustomUserDetails(user);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }
    }
}