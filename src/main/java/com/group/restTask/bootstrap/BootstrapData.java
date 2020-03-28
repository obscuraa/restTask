package com.group.restTask.bootstrap;

import com.group.restTask.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.group.restTask.domain.User;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootstrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating users..");

        User u1 = new User();
        u1.setName("John");
        u1.setWebPageID(1);
        u1.setNumOfVisits(10);
        u1.setDayOfVisit(1);
        userRepository.save(u1);

        User u2 = new User();
        u2.setName("Jim");
        u2.setWebPageID(1);
        u2.setNumOfVisits(9);
        u2.setDayOfVisit(1);
        userRepository.save(u2);

        User u3 = new User();
        u3.setName("Joe");
        u3.setWebPageID(1);
        u3.setNumOfVisits(12);
        u3.setDayOfVisit(2);
        userRepository.save(u3);

        System.out.println("Users saved: " + userRepository.count());
    }
}
