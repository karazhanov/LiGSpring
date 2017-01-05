package ua.com.lig.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author karazhanov on 05.01.17.
 */
@Configuration
public class AppConfig {

    @Bean
    public Client client() {
        return new Client("1", "SMIT");
    }
//
//    @Bean
//    public App appT() {
//        return new App();
//    }

    @Bean
    @Scope("prototype")
    public Event event(){
        return new Event(new Date(), DateFormat.getDateInstance());
    }

//    @Autowired
//    private EventLogger combinedEventLogger;
}
