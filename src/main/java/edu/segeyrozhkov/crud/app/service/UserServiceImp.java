package edu.segeyrozhkov.crud.app.service;

import edu.segeyrozhkov.crud.app.dao.UserDao;
import edu.segeyrozhkov.crud.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createOrUpdateUser(User user) {
        userDao.createOrUpdateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }
}

