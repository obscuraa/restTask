package com.group.restTask.services;

import com.group.restTask.domain.User;
import com.group.restTask.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByID(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public long findVisitsByDay(long dayOfVisit) {
        return userRepository.findVisitsByDay(dayOfVisit);
    }

    @Override
    public long findUniqueUsersByDay(long dayOfVisit){
        return userRepository.findUniqueUsersByDay(dayOfVisit);
    }

    @Override
    public long findUniqueAndLoyalUsersByDay(long dayOfVisit){
        return userRepository.findUniqueAndLoyalUsersByDay(dayOfVisit);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public long findCurrentDayVisits(){
        return userRepository.findCurrentDayVisits();
    }

    @Override
    public long findCurrentDayUniqueUsers(){
        return userRepository.findCurrentDayUniqueUsers();
    }
}
