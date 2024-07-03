package com.itranswarp.learnjava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itranswarp.learnjava.validator.Validators;

@Component
public class UserService {
    @Autowired
    MailService mMailService;

    @Autowired
    Validators validators;

    public UserService(@Autowired MailService mailService) {
        this.mMailService = mailService;
    }

    private List<User> users = new ArrayList<User>(List.of(
            new User(1, "bob@example.com", "password", "Bob"), // bob
            new User(2, "alice@example.com", "password", "Alice"), // alice
            new User(3, "tom@example.com", "password", "Tom"))); // tom

    public User login(String email, String password) {
        for (User user : users) {
            System.out.println("user " + user.getEmail());
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mMailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    public User register(String email, String password, String name) {
        System.out.println(email + " " + password + " " + name);
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mMailService.sendRegistrationMail(user);
        return user;
    }
}
