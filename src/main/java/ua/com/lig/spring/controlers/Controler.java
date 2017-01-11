package ua.com.lig.spring.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.lig.spring.configs.beans.UserService;
import ua.com.lig.spring.storage.dao.UserDao;
import ua.com.lig.spring.storage.dao.jdbc.JdbsTemplateUserDao;
import ua.com.lig.spring.storage.entity.User;

import java.util.List;

/**
 * @author karazhanov on 10.01.17.
 */
@RestController
@RequestMapping("/user")
public class Controler {

    @Autowired private UserService userService;
    @Autowired private UserDao userDao;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        userService.logUser();
        return userDao.getUsers();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id) {
        userService.logUser();
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String createUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        return "id = " + userDao.createUser(login, password);
    }
}
