package com.example.finalprojectj19spring.services;

import com.example.finalprojectj19spring.exceptions.CarNotFoundException;
import com.example.finalprojectj19spring.exceptions.UserNotFoundException;
import com.example.finalprojectj19spring.models.Car;
import com.example.finalprojectj19spring.models.User;

import java.util.List;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public interface UserService {
    /**
     * To find all users
     *
     * @return a list of User
     */
    List<User> findAllUsers();

    /**
     * To find user by Username
     *
     * @param username username
     * @return User
     */
    User findUserByUsername(String username) throws UserNotFoundException;

    /**
     * To create a new User
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To update on existing User
     *
     * @param  user User
     */

    void updateUser(User user) throws CarNotFoundException, UserNotFoundException;
}
