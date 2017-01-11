package ua.com.lig.spring.storage.dao;

import ua.com.lig.spring.storage.entity.User;

import java.util.List;

/**
 * @author karazhanov on 10.01.17.
 */
public interface UserDao {
    int createUser(String login, String password);
    User getUserById(Integer id);
    List<User> getUsers();
}
