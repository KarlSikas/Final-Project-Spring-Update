package com.example.finalprojectj19spring.services;

import com.example.finalprojectj19spring.exceptions.AuthorityNotFoundException;
import com.example.finalprojectj19spring.exceptions.UserNotFoundException;
import com.example.finalprojectj19spring.models.Authority;
import com.example.finalprojectj19spring.models.User;

import java.util.List;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public interface AuthorityService {
    /**
     * To fina all authorities
     *
     * @return a list of authorities
     */
    List<Authority> findAllAuthorities();

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;

    /**
     * To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);
}