package com.example.finalprojectspring.exceptions;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public class UserValidationException extends Exception {
    private static final long serialVersionUID = 1L;
    public UserValidationException(String name, String message){
        super(String.format("User validation failed for user: %s", name, message));
    }
}