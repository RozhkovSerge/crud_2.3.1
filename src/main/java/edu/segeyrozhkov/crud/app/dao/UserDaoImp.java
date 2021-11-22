package edu.segeyrozhkov.crud.app.dao;

import edu.segeyrozhkov.crud.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> userList() {
        return entityManager.createQuery("SELECT users from User users").getResultList();
    }

//    @PostConstruct
//    public void populateDB() {
//        User user1 = new User("Bob", "IT", 500);
//        User user2 = new User("Mary", "Sales", 200);
//        User user3 = new User("Mike", "HR", 300);
//
//        entityManager.merge(user1);
//        entityManager.merge(user2);
//        entityManager.merge(user3);
//    }
}
