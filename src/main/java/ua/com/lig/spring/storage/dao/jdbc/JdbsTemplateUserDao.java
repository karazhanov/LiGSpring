package ua.com.lig.spring.storage.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.com.lig.spring.storage.dao.UserDao;
import ua.com.lig.spring.storage.dao.jdbc.mappers.UserMapper;
import ua.com.lig.spring.storage.entity.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author karazhanov on 11.01.17.
 */
public class JdbsTemplateUserDao implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private UserMapper rowMapper;

    public JdbsTemplateUserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = new UserMapper();
    }

    @Override
    public int createUser(String login, String password) {
        String SQL = "INSERT INTO user (login, password) VALUES (?,?)";
        return jdbcTemplate.update(SQL, login, password);
    }

    @Override
    public User getUserById(Integer id) {
        String SQL = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, rowMapper);
    }

    @Override
    public List<User> getUsers() {
        String SQL ="SELECT * FROM user";
        return jdbcTemplate.query(SQL, rowMapper);
    }
}
