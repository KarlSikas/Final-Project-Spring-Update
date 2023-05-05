package com.example.finalprojectj19spring.utils;

import com.example.finalprojectspring.exceptions.UserValidationException;
import com.example.finalprojectspring.models.User;
import com.example.finalprojectspring.models.UserType;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public class UserValidator {
    public boolean isOwnerUser(User user) throws UserValidationException {
        String fullName = user.getFirsName() + " " + user.getLastName();

        if(user.getUserType() == null) {
            throw new NullPointerException(String.format("The user type is null for user: %s", fullName));
        }
        if (UserType.OWNER.equals(user.getUserType())){
            return true;
        } else {
            throw new UserValidationException(fullName, "User owner check failed!");
        }
    }
}