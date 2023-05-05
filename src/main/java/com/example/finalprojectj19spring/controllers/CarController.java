package com.example.finalprojectj19spring.controllers;

import com.example.finalprojectj19spring.exceptions.CarNotFoundException;
import com.example.finalprojectj19spring.models.Car;
import com.example.finalprojectj19spring.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public String showCarListPage(Model model, @ModelAttribute("message") String message,
                                  @ModelAttribute("messageType") String messageType) {
        model.addAttribute("cars", carService.findAllCars());
        return "car/list-car";
    }


    @GetMapping("/create")
    public String showCreateCarPage(@ModelAttribute("car") Car car,
                                    @ModelAttribute("message") String message,
                                    @ModelAttribute("messageType") String messageType) {
        return "car/create-car";
    }

    @PostMapping
    public String createCar(Car car, RedirectAttributes redirectAttributes) {
        try {
            Car searchCar = carService.findCarByModelName(car.getModelName());
            redirectAttributes.addFlashAttribute("message", String.format("Car(%s) already exists!", car.getModelName()));
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/car/create-car";
        } catch (CarNotFoundException e) {
            carService.addCar((car));
            redirectAttributes.addFlashAttribute("message", String.format("Car(%s) has been created successfully!", car.getModelName()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/car";
        }

    }

    @GetMapping("/update/{id}")
    public String showUpdateCarPage(@PathVariable Long id, RedirectAttributes redirectAttributes,
                                    @RequestParam(value = "car", required = false) Car car,
                                    Model model) {
        if (car == null) {
            try {
                model.addAttribute("car", carService.findCarById(id));
            } catch (CarNotFoundException e) {
                return handleException(redirectAttributes, e);
            }
        }

        return "car/update-car";
    }

    @PostMapping("/update")
    public String updateCar(Car car, RedirectAttributes redirectAttributes) {
        try {
            carService.updateCar(car);
            redirectAttributes.addFlashAttribute("message", String.format("Car(id=%d) has been updated successfully!", car.getId()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/car";
        } catch (CarNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }

    private String handleException(RedirectAttributes redirectAttributes, CarNotFoundException e) {
        redirectAttributes.addFlashAttribute("message", e.getLocalizedMessage());
        redirectAttributes.addFlashAttribute("messageType", "error");
        return "redirect:/car";
    }


    @GetMapping("/{id}")
    public String showCarViewPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("car", carService.findCarById(id));
            return "car/view-car";
        } catch (CarNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            carService.deleteCarById(id);
            redirectAttributes.addFlashAttribute("message", String.format("Car #%d rented successfully!", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/car";
        } catch (CarNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }
    @GetMapping("/restore/{id}")
    public String restoreCar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            carService.restoreCarById(id);
            redirectAttributes.addFlashAttribute("message", String.format("Car #%d returned successfully!", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/car";
        } catch (CarNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }
}