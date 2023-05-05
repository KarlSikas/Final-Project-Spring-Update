package com.example.finalprojectj19spring.exceptions;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public class AuthorityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AuthorityNotFoundException(String name) {
        super(String.format("Authority not found for name: %s", name));
    }
}
