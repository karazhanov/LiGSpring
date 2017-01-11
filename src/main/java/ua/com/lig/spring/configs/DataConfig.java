package ua.com.lig.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.com.lig.spring.storage.dao.UserDao;
import ua.com.lig.spring.storage.dao.jdbc.JdbsTemplateUserDao;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author karazhanov on 10.01.17.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class DataConfig {
    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_DATABASE_PASSWORD = "db.password";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "userDao")
    public UserDao jdbsTemplateUserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new JdbsTemplateUserDao(dataSource, jdbcTemplate);
    }
}
