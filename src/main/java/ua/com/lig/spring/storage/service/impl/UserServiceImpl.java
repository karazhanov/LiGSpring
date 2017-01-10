package ua.com.lig.spring.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.lig.spring.storage.entity.User;
import ua.com.lig.spring.storage.repository.UserRepository;
import ua.com.lig.spring.storage.service.UserService;

/**
 * @author karazhanov on 10.01.17.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
