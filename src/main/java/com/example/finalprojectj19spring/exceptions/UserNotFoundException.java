package com.example.finalprojectj19spring.exceptions;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String username) {
        super(String.format("User not found for username: %s!", username));
    }
}