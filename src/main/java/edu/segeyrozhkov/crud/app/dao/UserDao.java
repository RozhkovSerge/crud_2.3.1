package edu.segeyrozhkov.crud.app.dao;

import edu.segeyrozhkov.crud.app.model.User;

import java.util.List;

public interface UserDao {

     void createOrUpdateUser(User user);

     void removeUser(int id);

     User getUserById(int id);

     List<User> userList();


}
