package com.group.restTask.controllers;

import com.group.restTask.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.group.restTask.domain.User;

import java.util.List;

@RestController
@RequestMapping(UserController.Base_URL)
public class UserController {
    public static final String Base_URL = "api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id){
        return userService.findUserByID(id);
    }

    @GetMapping("/visits/{day}")
    public long getUserByDay(@PathVariable Long day){
        return userService.findVisitsByDay(day);
    }

    @GetMapping("/uniqueidsbyday/{day}")
    long findUniqueUsersByDay(@PathVariable Long day){
        return userService.findUniqueUsersByDay(day);
    }

    @GetMapping("/uniqueandloyalidsbyday/{day}")
    long findUniqueAndLoyalUsersByDay(@PathVariable Long day){
        return userService.findUniqueAndLoyalUsersByDay(day);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/currvisits")
    public long getCurrDayVisits(){
       return userService.findCurrentDayVisits();
    }

    @GetMapping("/currusers")
    public long getCurrDayUniqueUsers(){
        return userService.findCurrentDayUniqueUsers();
    }
}
