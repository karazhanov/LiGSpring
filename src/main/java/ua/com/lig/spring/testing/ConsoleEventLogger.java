package ua.com.lig.spring.testing;

import org.springframework.stereotype.Component;

/**
 * @author karazhanov on 04.01.17.
 */
@Component("consoleEL")
public class ConsoleEventLogger implements EventLogger{

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
