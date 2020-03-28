package com.group.restTask.services;

import com.group.restTask.domain.User;

import java.util.List;

public interface UserService {
    User findUserByID(long id);
    List<User> findAllUsers();
    User saveUser(User user);
    long findCurrentDayVisits();
    long findVisitsByDay(long dayOfVisit);
    long findUniqueUsersByDay(long dayOfVisit);
    long findUniqueAndLoyalUsersByDay(long dayOfVisit);
    long findCurrentDayUniqueUsers();

}
