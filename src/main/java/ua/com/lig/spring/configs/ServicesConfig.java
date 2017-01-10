package ua.com.lig.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.com.lig.spring.configs.beans.UserService;

/**
 * @author karazhanov on 10.01.17.
 */
@Configuration
//@EnableWebMvc
public class ServicesConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    //////////////////////////////////////////////////////////////////////

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/user/");
//        registry.addViewController("/user").setViewName("forward:/user/");
//        registry.addViewController("/user/").setViewName("forward:/user/");
//    }
}
