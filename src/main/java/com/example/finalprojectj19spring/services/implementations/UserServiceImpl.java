package com.example.finalprojectj19spring.services.implementations;

import com.example.finalprojectspring.exceptions.CarNotFoundException;
import com.example.finalprojectspring.exceptions.UserNotFoundException;
import com.example.finalprojectspring.models.Car;
import com.example.finalprojectspring.models.User;
import com.example.finalprojectspring.repositories.UserRepository;
import com.example.finalprojectspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(username);
        }

        return optionalUser.get();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        if(findUserByUsername(user.getUsername()) != null) {
            userRepository.saveAndFlush(user);
        }
    }
}