package com.example.finalprojectj19spring.controllers;


import com.example.finalprojectspring.exceptions.CarNotFoundException;
import com.example.finalprojectspring.exceptions.UserNotFoundException;
import com.example.finalprojectspring.models.Car;
import com.example.finalprojectspring.models.User;
import com.example.finalprojectspring.services.AuthorityService;
import com.example.finalprojectspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle all user related requests
 *
 * @author Karl-Erik Sirkas
 * @Date 13.03.2023
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public String showAllUserPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user/list-user";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model, @ModelAttribute("user") User user, @ModelAttribute("message") String message,
                                 @ModelAttribute("messageType") String messageType) {
        model.addAttribute("authorities", authorityService.findAllAuthorities());
        return "user/create-user";
    }

    @PostMapping("/signup")
    public String createUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.findUserByUsername(user.getUsername());
            redirectAttributes.addFlashAttribute("message", String.format("User(%s) already exists!", user.getUsername()));
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/home/signup";
        } catch (UserNotFoundException e) {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "Signup successful!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/";
        }
    }
    @GetMapping("/update/{username}")
    public String showUpdateUserPage(@PathVariable String username, RedirectAttributes redirectAttributes,
                                     @RequestParam(value = "user", required = false) User user,
                                     Model model) {
        if (user == null) {
            try {
                model.addAttribute("user", userService.findUserByUsername(username));
            } catch (UserNotFoundException e) {
                return "redirect:/";
            }
        }

        return "user/update-user";
    }

    @PostMapping("/update")
    public String updateUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(user);
            redirectAttributes.addFlashAttribute("message", String.format("User(id=%d) has been updated successfully!", user.getId()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/user";
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CarNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}