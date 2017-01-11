package ua.com.lig.spring.storage.dao.jdbc.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.com.lig.spring.storage.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author karazhanov on 11.01.17.
 */
public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
