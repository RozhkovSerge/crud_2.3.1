package edu.segeyrozhkov.crud.app.service;

import edu.segeyrozhkov.crud.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PopulateDB {
    private UserService userService;

    @Autowired
    public PopulateDB(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void populateDB() {
        User user1 = new User("Bob", "IT", 500);
        User user2 = new User("Mary", "Sales", 200);
        User user3 = new User("Mike", "HR", 300);

        userService.updateUser(user1);
        userService.updateUser(user2);
        userService.updateUser(user3);
    }
}
