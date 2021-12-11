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
    private void populateDB() {

        User user1 = new User("Bob", "IT", 1000);
        User user2 = new User("Maria", "HR", 1000);
        userService.add((user1));
        userService.add((user2));
    }
}
