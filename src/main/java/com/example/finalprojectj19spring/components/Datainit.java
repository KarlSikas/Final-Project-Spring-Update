package com.example.finalprojectj19spring.components;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/23/2023
 */


import com.example.finalprojectspring.exceptions.AuthorityNotFoundException;
import com.example.finalprojectspring.exceptions.BranchNotFoundException;
import com.example.finalprojectspring.exceptions.CarNotFoundException;
import com.example.finalprojectspring.exceptions.UserNotFoundException;
import com.example.finalprojectspring.models.*;
import com.example.finalprojectspring.services.AuthorityService;
import com.example.finalprojectspring.services.BranchService;
import com.example.finalprojectspring.services.CarService;
import com.example.finalprojectspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.example.finalprojectspring.utils.Constants.Security.*;

@Component
public class Datainit {
    @Autowired
    private BranchService branchService;

    @Autowired
    private CarService carService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserService userService;



    @PostConstruct
    public void init() throws BranchNotFoundException {
        initBranch();
        initCar();
        initBooking();
        initAuthority();
        initUser();
    }


    private  void initBranch(){
        System.out.println("Starting Branch initialization...");
        Branch branch = new Branch();
        branch.setAddress("Tallinn");

        try {
            Branch searchBranch = branchService.findBranchByAddress(branch.getAddress());
            System.out.println("Cannot pre-initialize school: " + branch.getAddress());
        } catch (BranchNotFoundException e) {
            branchService.createBranch(branch);
        }


    }


    private void initCar() throws BranchNotFoundException {
        System.out.println("Starting cars initialization...");
        Branch searchBranch = branchService.findBranchByAddress("Tallinn");

        Car car = new Car();
        car.setModelName("Ford");
        car.setColor("black");
        car.setBodyType("sedan");
        car.setYearOfProd(2023);
        car.setBranch(searchBranch);
        car.setMileage(15000);
        car.setImgUrl("https://quickbutik.imgix.net/13175t/products/5ddd132135e57.jpeg");
        car.setBooked(true);

        try {
            Car searchCar = carService.findCarByModelName(car.getModelName());
            System.out.println("Cannot pre-initialize car: " + car.getModelName());
        } catch (CarNotFoundException e) {
            carService.addCar(car);
        }
    }

    private  void initCustomer(){

    }

    private  void initBooking(){

    }
    private void initAuthority() {
        System.out.println("Starting initializing Authority..");
        Authority authorityOwner = new Authority();
        authorityOwner.setName(AUTHORITY_OWNER);
        createAuthority(authorityOwner);

        Authority authorityEmployee = new Authority();
        authorityEmployee.setName(AUTHORITY_EMPLOYEE);
        createAuthority(authorityEmployee);

        Authority authorityCustomer = new Authority();
        authorityCustomer.setName(AUTHORITY_CUSTOMER);
        createAuthority(authorityCustomer);
    }


    private void initUser() {
        System.out.println("Starting initializing User..");

        try {
            Authority authority = authorityService.findAuthorityByName(AUTHORITY_OWNER);

            User user = new User();
            user.setUsername("owner@rental.com");
            user.setFirsName("Sergei");
            user.setLastName("Oksanen");
            user.setAddress("Tallinn");
            user.setUserType(UserType.OWNER);
            user.setActive(true);
            user.setPassword("123456");
            user.setAuthority(authority);

            try {
                User resultUser = userService.findUserByUsername(user.getUsername());
                System.out.println("Cannot pre-initialize user: " + user.getUsername());
            } catch(UserNotFoundException e) {
                userService.createUser(user);
            }
        } catch (AuthorityNotFoundException e) {
            System.out.println("Cannot pre-initialize User! Reason:  " + e.getLocalizedMessage());
        }
    }

    private void createAuthority(Authority authority) {
        try {
            Authority resultAuthority = authorityService.findAuthorityByName(authority.getName());
            System.out.println("Cannot pre-initialize authority: " + authority.getName());
        } catch (AuthorityNotFoundException e) {
            authorityService.createAuthority(authority);
        }
    }
}